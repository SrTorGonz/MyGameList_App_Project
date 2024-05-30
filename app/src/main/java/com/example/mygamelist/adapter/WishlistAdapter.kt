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

class WishlistAdapter (private val gameList:ArrayList<GamesFirebase> ): RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistAdapter.WishlistViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_wishlist,
            parent,false)
        return WishlistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WishlistAdapter.WishlistViewHolder, position: Int) {
        val game:GamesFirebase=gameList[position]
        holder.gameName.text= game.nombre

        Glide.with(holder.itemView.context)
            .load(game.imagenPortada)
            .into(holder.imagenPortada)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    public class WishlistViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val gameName:TextView=itemView.findViewById(R.id.text_gameName)
        val imagenPortada:ImageView=itemView.findViewById(R.id.img_portada)

    }
}