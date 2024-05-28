package com.example.mygamelist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygamelist.CustomItemDecoration
import com.example.mygamelist.GamesProvider
import com.example.mygamelist.MainActivity
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego
import com.example.mygamelist.adapter.LatestReleasesAdapter
import com.example.mygamelist.adapter.SearchAdapter
import com.example.mygamelist.databinding.FragmentHomeBinding
import com.example.mygamelist.ui.dashboard.SearchFragmentDirections

class HomeFragment : Fragment() {

    private var gameMutableList:MutableList<Videojuego> = GamesProvider.GameList.toMutableList()
    private lateinit var adapter: LatestReleasesAdapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(


        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textViewPrueba = root.findViewById<TextView>(R.id.text_prueba)
        //textViewPrueba.text=email
        /*
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        */

        //iniciar el recyclerview
        initRecyclerView()
        return root
    }

    //funcion que inicializa el recyclerview
    private fun initRecyclerView(){
        adapter = LatestReleasesAdapter(gameMutableList.filter { videojuego ->videojuego.categoria.equals("B")  }){videojuego ->
            onItemSelected(
                videojuego
            )
        }

        val manager = GridLayoutManager(requireContext(),3)
        binding.recyclerLatestReleases.layoutManager=manager
        binding.recyclerLatestReleases.adapter = adapter

        //añadir separacion entre items
        val spaceHeight = resources.getDimensionPixelSize(R.dimen.recycler_view_item_space)
        val customItemDecoration = CustomItemDecoration(spaceHeight)
        binding.recyclerLatestReleases.addItemDecoration(customItemDecoration)

    }

    fun onItemSelected(videojuego: Videojuego){

        val action = HomeFragmentDirections.actionNavigationHomeToNavigationGame(videojuego)
        findNavController().navigate(action)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}