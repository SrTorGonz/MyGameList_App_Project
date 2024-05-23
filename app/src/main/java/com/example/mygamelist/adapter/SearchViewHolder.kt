package com.example.mygamelist.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygamelist.R
import com.example.mygamelist.Videojuego

class SearchViewHolder (view: View): RecyclerView.ViewHolder(view){

    val imgPortada = view.findViewById<ImageView>(R.id.img_portada)
    val gameName = view.findViewById<TextView>(R.id.text_Name)

    fun render(gameModel: Videojuego){
        gameName.text = gameModel.nombre
        Glide.with(imgPortada)
            .load(gameModel.imagenPortada)
            .into(imgPortada)
    }
}