package com.example.mygamelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego

class BestScoresAdapter(private var GameList:List<Videojuego>, private val onClickListener:(Videojuego) ->Unit): RecyclerView.Adapter<BestScoresViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestScoresViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return BestScoresViewHolder(layoutInflater.inflate(R.layout.item_best_scores,parent,false))
    }

    override fun getItemCount(): Int {
        return GameList.size
    }

    override fun onBindViewHolder(holder: BestScoresViewHolder, position: Int) {
        val item = GameList[position]
        holder.render(item, onClickListener)
    }

    fun updateGames(GameList:List<Videojuego>){
        this.GameList = GameList
        notifyDataSetChanged()
    }

}