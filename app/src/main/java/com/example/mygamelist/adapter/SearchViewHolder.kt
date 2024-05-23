package com.example.mygamelist.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego
import com.example.mygamelist.databinding.ItemSearchGamesBinding

class SearchViewHolder (view: View): RecyclerView.ViewHolder(view){

    val binding = ItemSearchGamesBinding.bind(view)


    fun render(gameModel: Videojuego){
        binding.textName.text = gameModel.nombre
        Glide.with(binding.imgPortada)
            .load(gameModel.imagenPortada)
            .into(binding.imgPortada)
    }
}