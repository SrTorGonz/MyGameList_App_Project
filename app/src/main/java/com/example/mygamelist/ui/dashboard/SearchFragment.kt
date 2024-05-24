package com.example.mygamelist.ui.dashboard

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygamelist.CustomItemDecoration
import com.example.mygamelist.GameFragment
import com.example.mygamelist.GamesProvider
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego
import com.example.mygamelist.adapter.SearchAdapter
import com.example.mygamelist.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var gameMutableList:MutableList<Videojuego> = GamesProvider.GameList.toMutableList()
    private lateinit var adapter: SearchAdapter

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*
        val textView: TextView = binding.textDashboard
        searchViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        */

        //recibir el edit text y detectar cuando cambia el texto, filtrar juegos
        binding.etFilter.addTextChangedListener{userFilter->
            val gamesFiltered = gameMutableList.filter{game -> game.nombre.lowercase().contains(userFilter.toString().lowercase())}
            adapter.updateGames(gamesFiltered)
        }

        //iniciar el recyclerview
        initRecyclerView()

        return root
    }

    //funcion que inicializa el recyclerview
    private fun initRecyclerView(){
        adapter = SearchAdapter(gameMutableList){videojuego ->
            onItemSelected(
                videojuego
            )
        }

        val manager = LinearLayoutManager(requireContext())
        binding.recyclerSearch.layoutManager=manager
        binding.recyclerSearch.adapter = adapter

        //añadir separacion entre items
        val spaceHeight = resources.getDimensionPixelSize(R.dimen.recycler_view_item_space)
        val customItemDecoration = CustomItemDecoration(spaceHeight)
        binding.recyclerSearch.addItemDecoration(customItemDecoration)

    }
    //cuando se toca un item se ejecuta esto
    fun onItemSelected(videojuego: Videojuego){

        val action = SearchFragmentDirections.actionNavigationSearchToNavigationGame(videojuego)
        findNavController().navigate(action)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}