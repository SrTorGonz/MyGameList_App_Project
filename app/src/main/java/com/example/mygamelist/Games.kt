package com.example.mygamelist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Videojuego(
    val nombre: String,
    val sinopsis: String,
    val imagenPortada: String, // URL de la imagen de portada
    val fechaLanzamiento: String,
    val plataformas: List<String>,
    val tags: List<String>
): Parcelable


