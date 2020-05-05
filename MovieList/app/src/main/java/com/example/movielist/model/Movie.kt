package com.example.movielist.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(
    @SerializedName("backdrop_path")
    val backdrop: String,
    @SerializedName("poster_path")
    val poster: String,
    val title: String,
    @SerializedName("release_date")
    val releaseDate: Date,
    @SerializedName("vote_average")
    val Rating: Double,
    @SerializedName("overview")
    val descriptionMovie: String
) {
    fun getBackdropUrl() = "https://image.tmdb.org/t/p/w500$backdrop"
    fun getPosterUrl() = "https://image.tmdb.org/t/p/w500$poster"
}
