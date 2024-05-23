package com.example.mygamelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygamelist.GamesProvider
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego

class SearchAdapter(private var GameList:List<Videojuego>,private val onClickListener:(Videojuego) ->Unit): RecyclerView.Adapter<SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(layoutInflater.inflate(R.layout.item_search_games,parent,false))
    }

    override fun getItemCount(): Int {
        return GameList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = GameList[position]
        holder.render(item, onClickListener)
    }

    fun updateGames(GameList:List<Videojuego>){
        this.GameList = GameList
        notifyDataSetChanged()
    }

}