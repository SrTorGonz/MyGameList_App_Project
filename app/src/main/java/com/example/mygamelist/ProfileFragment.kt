package com.example.mygamelist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mygamelist.MainActivity
import com.example.mygamelist.R
import com.example.mygamelist.databinding.FragmentHomeBinding
import com.example.mygamelist.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(


        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textViewPrueba = root.findViewById<TextView>(R.id.text_prueba)
        //textViewPrueba.text=email

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}