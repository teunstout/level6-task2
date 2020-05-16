package com.example.movielist.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("backdrop_path") val backdropPath : String,
    @SerializedName("poster_path") val posterPath : String,
    @SerializedName("title") val title : String,
    @SerializedName("release_date") val releaseDate : String,
    @SerializedName("vote_average") val rating : Double,
    @SerializedName("overview") val descriptionMovie: String
) {
    fun getBackdropUrl() = "https://image.tmdb.org/t/p/w500$backdropPath"
    fun getPosterUrl() = "https://image.tmdb.org/t/p/w500$posterPath"
}
