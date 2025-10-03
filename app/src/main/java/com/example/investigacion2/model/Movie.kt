package com.example.investigacion2.model

import androidx.compose.runtime.mutableStateListOf

data class Movie(
    val id: Int,
    val title: String,
    val year: String,
    val genre: String,
    val rating: Float,
    val imageUrl: String,
    val description: String
)

val sampleMovies = listOf(
    Movie(
        id = 1,
        title = "Barbie",
        year = "2023",
        genre = "Comedia",
        rating = 4.5f,
        imageUrl = "https://whatismetamodern.com/wp-content/uploads/2023/10/Barbie-Movie-2023.png",
        description = "Barbie y Ken están en el mundo real"
    ),
    Movie(
        id = 2,
        title = "Mean Girls",
        year = "2004",
        genre = "Comedia",
        rating = 4.2f,
        imageUrl = "https://www.marthadebayle.com/wp-content/uploads/2024/04/mean-girls-20-anos-fun-facts.jpg",
        description = "Historia sobre amistad y rivalidad"
    ),
    Movie(
        id = 3,
        title = "Legally Blonde",
        year = "2001",
        genre = "Comedia",
        rating = 4.3f,
        imageUrl = "https://play-lh.googleusercontent.com/eBo3d9mm7XUdFFwmn4EVDYpOJV3yOftVA4Ln9-tCt1Lqvx4yom4NaIUG-b_miffT86QMu2nQSyJTZ2Pzqr4",
        description = "Elle Woods demuestra que es más que su apariencia"
    )
)

val favoriteMovies = mutableStateListOf<Int>()

fun toggleFavorite(movieId: Int) {
    if (favoriteMovies.contains(movieId)) {
        favoriteMovies.remove(movieId)
    } else {
        favoriteMovies.add(movieId)
    }
}

fun Movie.isFavorite(): Boolean {
    return favoriteMovies.contains(this.id)
}

val movieCategories = listOf(
    "Todas", "Comedia", "Drama", "Acción", "Romance", "Animación"
)