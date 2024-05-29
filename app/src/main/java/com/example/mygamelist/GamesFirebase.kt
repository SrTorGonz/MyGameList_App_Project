package com.example.mygamelist

data class GamesFirebase(

    var categoria: String? = null,
    var comment: String? = null,
    var fechaLanzamiento: String? = null,
    var imagenHorizontal: String? = null,
    var imagenPortada: String?=null,
    var nombre: String? = null,
    var plataformas: List<String>? = null,
    var ratingG: Int? = null,
    var ratingP: Int? = null,
    var sinopsis: String? = null,
    var tags: List<String>? = null,
)
