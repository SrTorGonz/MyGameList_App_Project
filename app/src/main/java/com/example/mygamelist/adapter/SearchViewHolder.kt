package com.example.mygamelist.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego
import com.example.mygamelist.databinding.ItemSearchGamesBinding

class SearchViewHolder (view: View): RecyclerView.ViewHolder(view){

    val binding = ItemSearchGamesBinding.bind(view)


    fun render(gameModel: Videojuego, onClickListener:(Videojuego) ->Unit){
        binding.textName.text = gameModel.nombre
        Glide.with(binding.imgPortada)
            .load(gameModel.imagenPortada)
            .into(binding.imgPortada)
        binding.textSynopsis.text =gameModel.sinopsis

        itemView.setOnClickListener{ onClickListener(gameModel)}

    }
}