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

class PlayingAdapter (private val gameList:ArrayList<GamesFirebase> ): RecyclerView.Adapter<PlayingAdapter.PlayingViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayingAdapter.PlayingViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_my_list,
            parent,false)
        return PlayingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlayingAdapter.PlayingViewHolder, position: Int) {
        val game:GamesFirebase=gameList[position]
        holder.gameName.text= game.nombre
        holder.score.text=game.ratingP.toString()
        holder.review.text=game.comment

        Glide.with(holder.itemView.context)
            .load(game.imagenPortada)
            .into(holder.imagenPortada)
    }

    override fun getItemCount(): Int {
       return gameList.size
    }

    public class PlayingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val gameName:TextView=itemView.findViewById(R.id.text_gameName)
        val score:TextView=itemView.findViewById(R.id.text_userScore)
        val review:TextView=itemView.findViewById(R.id.text_review)
        val imagenPortada:ImageView=itemView.findViewById(R.id.img_portada)

    }
}