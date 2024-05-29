package com.example.mygamelist

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mygamelist.databinding.FragmentGameBinding
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val args: GameFragmentArgs by navArgs()
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {

        _binding = FragmentGameBinding.inflate(inflater, container, false)

        val root: View = binding.root

        args.videojuego

        // Mostrar la información del videojuego
        binding.txtGameName.text = args.videojuego.nombre
        binding.textSynopsis.text = args.videojuego.sinopsis
        Glide.with(binding.portada)
            .load(args.videojuego.imagenPortada)
            .into(binding.portada)
        binding.txtFecha.text=args.videojuego.fechaLanzamiento

        // Mostrar las plataformas
        if (args.videojuego.plataformas.size > 0) {
            binding.plat1.text = args.videojuego.plataformas[0]
        } else {
            binding.plat1.visibility = View.GONE // Oculta el TextView si no hay datos
        }

        if (args.videojuego.plataformas.size > 1) {
            binding.plat2.text = args.videojuego.plataformas[1]
        } else {
            binding.plat2.visibility = View.GONE // Oculta el TextView si no hay datos
        }

        if (args.videojuego.plataformas.size > 2) {
            binding.plat3.text = args.videojuego.plataformas[2]
        } else {
            binding.plat3.visibility = View.GONE // Oculta el TextView si no hay datos
        }

        if (args.videojuego.plataformas.size > 3) {
            binding.plat4.text = args.videojuego.plataformas[3]
        } else {
            binding.plat4.visibility = View.GONE // Oculta el TextView si no hay datos
        }

        // Mostrar los tags
        if (args.videojuego.tags.size > 0) {
            binding.tag1.text = args.videojuego.tags[0]
        } else {
            binding.tag1.visibility = View.GONE // Oculta el TextView si no hay datos
        }

        if (args.videojuego.tags.size > 1) {
            binding.tag2.text = args.videojuego.tags[1]
        } else {
            binding.tag2.visibility = View.GONE // Oculta el TextView si no hay datos
        }

        if (args.videojuego.tags.size > 2) {
            binding.tag3.text = args.videojuego.tags[2]
        } else {
            binding.tag3.visibility = View.GONE // Oculta el TextView si no hay datos
        }

        if (args.videojuego.tags.size > 3) {
            binding.tag4.text = args.videojuego.tags[3]
        } else {
            binding.tag4.visibility = View.GONE // Oculta el TextView si no hay datos
        }


        binding.buttonAddGame.setOnClickListener{
            showEditNicknameDialog()
        }

        //ir para atras
        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.txtBack.setOnClickListener {
            findNavController().popBackStack()
        }

        return root
    }
    //funciones para editar el nickname
    private fun showEditNicknameDialog() {
        var puntuacion = 0
        var categoria = ""
        var comentario = ""

        val builder = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(com.example.mygamelist.R.layout.dialog_add_game, null)
        //almacenar review
        val editText = dialogLayout.findViewById<EditText>(com.example.mygamelist.R.id.editReview)


        //botones de categoria
        val btnPlaying = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btnPlaying)
        val btnCompleted = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btnCompleted)
        val btnDropped = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btnDropped)
        val btnWishlist = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btnWishlist)


        //botones de puntuacion
        val btn1 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn1)
        val btn2 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn2)
        val btn3 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn3)
        val btn4 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn4)
        val btn5 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn5)
        val btn6 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn6)
        val btn7 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn7)
        val btn8 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn8)
        val btn9 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn9)
        val btn10 = dialogLayout.findViewById<Button>(com.example.mygamelist.R.id.btn10)

        //acciones de categoria
        btnPlaying.setOnClickListener {
            it.isSelected = !it.isSelected
            categoria="Playing"
        }

        btnCompleted.setOnClickListener {
            it.isSelected = !it.isSelected
            categoria="Completed"
        }
        btnDropped.setOnClickListener {
            it.isSelected = !it.isSelected
            categoria="Dropped"
        }
        btnWishlist.setOnClickListener {
            it.isSelected = !it.isSelected
            categoria="WishList"
        }



        //acciones de puntuacion
        btn1.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=1
        }
        btn2.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=2
        }
        btn3.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=3
        }
        btn4.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=4
        }
        btn5.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=5
        }
        btn6.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=6
        }
        btn7.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=7
        }
        btn8.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=8
        }
        btn9.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=9
        }
        btn10.setOnClickListener {
            it.isSelected = !it.isSelected
            puntuacion=10
        }


        builder.setTitle("Add Videogame")
        builder.setView(dialogLayout)
        builder.setPositiveButton("Add") { dialog, which ->
            comentario = editText.text.toString()
            addGame(puntuacion,categoria,comentario)
        }
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    private fun addGame(puntuacionP: Int, categoriaP: String, reviewP: String){

        val updatedGame = args.videojuego.copy(
            categoria = categoriaP,
            ratingP = puntuacionP,
            comment = reviewP
        )
        saveList(updatedGame,categoriaP)
    }

    private fun saveList(game: Videojuego,categoriaP: String) {
        val db = FirebaseFirestore.getInstance()
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return

        db.collection("users").document(userEmail)
            .collection(categoriaP)
            .document(game.nombre)
            .set(game)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Game saved!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), "Error saving game", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
