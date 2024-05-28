package com.example.mygamelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego

class LatestReleasesAdapter(private var GameList:List<Videojuego>, private val onClickListener:(Videojuego) ->Unit): RecyclerView.Adapter<LatestReleasesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestReleasesViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return LatestReleasesViewHolder(layoutInflater.inflate(R.layout.item_latest_releases,parent,false))
    }

    override fun getItemCount(): Int {
        return GameList.size
    }

    override fun onBindViewHolder(holder: LatestReleasesViewHolder, position: Int) {
        val item = GameList[position]
        holder.render(item, onClickListener)
    }

    fun updateGames(GameList:List<Videojuego>){
        this.GameList = GameList
        notifyDataSetChanged()
    }

}