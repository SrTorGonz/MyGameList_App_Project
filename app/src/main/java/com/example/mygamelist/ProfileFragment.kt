package com.example.mygamelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mygamelist.MainActivity
import com.example.mygamelist.R
import com.example.mygamelist.databinding.FragmentHomeBinding
import com.example.mygamelist.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileFragment : Fragment() {

    private val db = FirebaseFirestore.getInstance()
    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(


        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var imageUrl: String? = null

        //recuperar imagen de perfil del usuario
        val userEmail = FirebaseAuth.getInstance().currentUser?.email ?: return root
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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}