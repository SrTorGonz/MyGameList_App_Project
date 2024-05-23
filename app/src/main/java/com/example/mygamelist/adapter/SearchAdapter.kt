package com.example.mygamelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygamelist.GamesProvider
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego

class SearchAdapter(private val GameList:List<Videojuego>): RecyclerView.Adapter<SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(layoutInflater.inflate(R.layout.item_search_games,parent,false))
    }

    override fun getItemCount(): Int {
        return GameList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = GameList[position]
        holder.render(item)
    }


}