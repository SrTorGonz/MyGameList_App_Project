package com.example.mygamelist.ui.dashboard

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mygamelist.CustomItemDecoration
import com.example.mygamelist.GamesProvider
import com.example.mygamelist.R
import com.example.mygamelist.adapter.SearchAdapter
import com.example.mygamelist.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

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

        //recuperar el recyyclerview
        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerSearch)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.adapter = SearchAdapter(GamesProvider.GameList)

        //aañadir separacion entre items
        val spaceHeight = resources.getDimensionPixelSize(R.dimen.recycler_view_item_space)
        val customItemDecoration = CustomItemDecoration(spaceHeight)
        recyclerView.addItemDecoration(customItemDecoration)

        binding.etFilter.addTextChangedListener{
            Log.i("aris",it.toString())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}