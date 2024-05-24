package com.example.mygamelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mygamelist.databinding.FragmentGameBinding
import androidx.navigation.fragment.findNavController

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

        //mostrar las plataformas
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





        //ir para atras
        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.txtBack.setOnClickListener {
            findNavController().popBackStack()
        }

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