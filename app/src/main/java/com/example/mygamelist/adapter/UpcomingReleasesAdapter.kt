package com.example.mygamelist.adapter

import com.example.mygamelist.adapter.LatestReleasesViewHolder
import com.example.mygamelist.adapter.UpcomingReleasesViewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego

class UpcomingReleasesAdapter(private var GameList:List<Videojuego>, private val onClickListener:(Videojuego) ->Unit): RecyclerView.Adapter<UpcomingReleasesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingReleasesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UpcomingReleasesViewHolder(layoutInflater.inflate(R.layout.item_upcoming_releases,parent,false))
    }

    override fun getItemCount(): Int {
        return GameList.size
    }

    override fun onBindViewHolder(holder: UpcomingReleasesViewHolder, position: Int) {
        val item = GameList[position]
        holder.render(item, onClickListener)
    }

    fun updateGames(GameList:List<Videojuego>){
        this.GameList = GameList
        notifyDataSetChanged()
    }

}
