package com.example.mygamelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mygamelist.databinding.FragmentGameBinding
import com.example.mygamelist.databinding.FragmentHomeBinding
import com.example.mygamelist.ui.home.HomeViewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
  /*  companion object {
        fun newInstance(): GameFragment {
            return GameFragment()
        }
    }

   */
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

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}