package com.example.mygamelist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygamelist.GamesFirebase
import com.example.mygamelist.R

class FavoritesAdapter (private val gameList:ArrayList<GamesFirebase> ): RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesAdapter.FavoritesViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_favorites,
            parent,false)
        return FavoritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritesAdapter.FavoritesViewHolder, position: Int) {
        val game:GamesFirebase=gameList[position]

        Glide.with(holder.itemView.context)
            .load(game.imagenPortada)
            .into(holder.imagenPortada)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    public class FavoritesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val imagenPortada:ImageView=itemView.findViewById(R.id.img_portada)

    }
}