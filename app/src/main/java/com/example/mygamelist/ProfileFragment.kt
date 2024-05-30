package com.example.mygamelist

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mygamelist.MainActivity
import com.example.mygamelist.R
import com.example.mygamelist.adapter.FavoritesAdapter
import com.example.mygamelist.adapter.PlayingAdapter
import com.example.mygamelist.databinding.FragmentHomeBinding
import com.example.mygamelist.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.FirebaseStorage

class ProfileFragment : Fragment() {

    private lateinit var gameArrayList:ArrayList<GamesFirebase>
    private lateinit var myAdapter: FavoritesAdapter
    private val db = FirebaseFirestore.getInstance()

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel


    override fun onCreateView(


        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return root

        pintarImgPerfil(userEmail)

        pintarNickname(userEmail)

        pintarBio(userEmail)


        binding.roundedProfileImageView.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Change profile picture")
                .setMessage("Do you want to change your profile picture")
                .setPositiveButton("Yes") { dialog, which ->
                    // Abre el selector de imágenes
                    val intent = Intent(Intent.ACTION_PICK)
                    intent.type = "image/*"
                    startActivityForResult(intent, PICK_IMAGE_REQUEST)
                }
                .setNegativeButton("No", null)
                .show()
        }
        //detectar click de l usuario en la bio
        binding.textBio.setOnClickListener {
            showEditBioDialog()
        }

        //detectar click del usuario en el icono de editar nickname
        binding.iconEditNickname.setOnClickListener{
            showEditNicknameDialog()
        }




        // Llama a la función para contar los documentos y actualizar los TextViews
        countDocumentsInCollection("Playing") { count ->
            binding.txtNumPlaying.text = "$count"
        }
        countDocumentsInCollection("Completed") { count ->
            binding.txtNumCompleted.text = "$count"
        }
        countDocumentsInCollection("Dropped") { count ->
            binding.txtNumDropped.text = "$count"
        }
        countDocumentsInCollection("WishList") { count ->
            binding.txtNumWishlist.text = "$count"
        }

        //recycler
        binding.recyclerFavs.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerFavs.setHasFixedSize(true)

        //añadir separacion entre items
        val spaceHeight = resources.getDimensionPixelSize(R.dimen.recycler_view_item_space)
        val customItemDecoration = CustomItemDecorationHorizontal(spaceHeight)
        binding.recyclerFavs.addItemDecoration(customItemDecoration)

        gameArrayList = arrayListOf()

        myAdapter = FavoritesAdapter(gameArrayList)
        binding.recyclerFavs.adapter = myAdapter

        eventChangeListener()

        //ir para atras
        binding.backIconProfile.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.txtBackProfile.setOnClickListener {
            findNavController().popBackStack()
        }


        return root
    }

    private fun eventChangeListener()
    {
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return
        db.collection("users").document(userEmail).collection("Favorites")
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(
                    value: QuerySnapshot?,
                    error: FirebaseFirestoreException?
                ) {
                    if (error !=null){
                        Toast.makeText(requireContext(), "Nothing to show", Toast.LENGTH_SHORT).show()
                        return
                    }

                    for(dc: DocumentChange in value?.documentChanges!!){

                        if (dc.type== DocumentChange.Type.ADDED){
                            gameArrayList.add(dc.document.toObject(GamesFirebase::class.java))
                        }
                    }

                    myAdapter.notifyDataSetChanged()
                }

            })
    }
    private fun countDocumentsInCollection(collectionName: String, callback: (Int) -> Unit) {

        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return
        db.collection("users").document(userEmail).collection(collectionName).get()
            .addOnSuccessListener { documents ->
                val count = documents.size()
                // Llama al callback con el conteo
                callback(count)
            }
            .addOnFailureListener { exception ->
                // Maneja el error y llama al callback con 0
                callback(0)
            }
    }

    //funciones para editar el nickname
    private fun showEditNicknameDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_nickname_change, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.editNicknameEditText)

        builder.setTitle("Edit Nickname")
        builder.setView(dialogLayout)
        builder.setPositiveButton("Save") { dialog, which ->
            val newNickname = editText.text.toString()
            updateNicknameInFirestore(newNickname)
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    private fun updateNicknameInFirestore(newNickname: String) {
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return
        val userRef = db.collection("users").document(userEmail)
        userRef.update("nickname", newNickname)
            .addOnSuccessListener {
                binding.txtNickname.text = newNickname
                Toast.makeText(context, "Nickname Updated", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "There was error updating your bio", Toast.LENGTH_SHORT).show()
            }
    }

    //funciones para editar la bio
    private fun showEditBioDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_bio_change, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.editBioEditText)

        builder.setTitle("Edit Bio")
        builder.setView(dialogLayout)
        builder.setPositiveButton("Save") { dialog, which ->
            val newBio = editText.text.toString()
            updateBioInFirestore(newBio)
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    private fun updateBioInFirestore(newBio: String) {
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return
        val userRef = db.collection("users").document(userEmail)
        userRef.update("bio", newBio)
            .addOnSuccessListener {
                binding.textBio.text = newBio
                Toast.makeText(context, "Bio Updated", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "There was error updating your bio", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val imageUri: Uri? = data.data

            // Subir la imagen a Firebase Storage
            uploadImageToFirebase(imageUri)
        }
    }

    private fun uploadImageToFirebase(imageUri: Uri?) {
        val storageRef = FirebaseStorage.getInstance().reference.child("profile_Pic/${FirebaseAuth.getInstance().currentUser?.email}.jpg")
        if (imageUri != null) {
            storageRef.putFile(imageUri)
                .addOnSuccessListener {
                    storageRef.downloadUrl.addOnSuccessListener { uri ->
                        val downloadUrl = uri.toString()
                        updateProfilePicUrl(downloadUrl)
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Error al subir la imagen", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun updateProfilePicUrl(downloadUrl: String) {
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return
        val userRef = db.collection("users").document(userEmail)
        userRef.update("profile_Pic", downloadUrl)
            .addOnSuccessListener {
                sharedViewModel.profilePicUrl.value = downloadUrl
                // Actualizar el ImageView con la nueva imagen
                Glide.with(this)
                    .load(downloadUrl)
                    .into(binding.roundedProfileImageView)
                Toast.makeText(context, "Imagen de perfil actualizada", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Error al actualizar la URL de la imagen", Toast.LENGTH_SHORT).show()
            }
    }

    companion object {
        const val PICK_IMAGE_REQUEST = 1
    }
    fun pintarImgPerfil(userEmail:String){
        var imageUrl: String? = null

        //recuperar imagen de perfil del usuario
        db.collection("users").document(userEmail).get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    imageUrl = document.getString("profile_Pic")
                    if (imageUrl != null) {
                        // Usar Glide para cargar la imagen
                        Glide.with(this)
                            .load(imageUrl)
                            .into(binding.roundedProfileImageView)
                    } else {
                        println("Profile Pic URL not found")
                    }
                } else {
                    println("No such document")
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting document: ${exception.message}")
            }

    }

    fun pintarNickname(userEmail: String){

        var nickname: String? = null
        //recuperar imagen de perfil del usuario
        db.collection("users").document(userEmail).get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    nickname = document.getString("nickname")
                    if (nickname != null) {

                        binding.txtNickname.text=nickname
                    } else {
                        println("Profile Pic URL not found")
                    }
                } else {
                    println("No such document")
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting document: ${exception.message}")
            }
    }

    fun pintarBio(userEmail: String){

        var bio: String? = null
        //recuperar imagen de perfil del usuario
        db.collection("users").document(userEmail).get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    bio = document.getString("bio")
                    if (bio != null) {
                        binding.textBio.text=bio
                    } else {
                        println("Profile Pic URL not found")
                    }
                } else {
                    println("No such document")
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting document: ${exception.message}")
            }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}