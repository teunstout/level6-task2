package com.example.movielist.model

import com.google.gson.annotations.SerializedName

data class MovieResponseObject(
    @SerializedName("page") val page : Int,
    @SerializedName("total_results") val totalResults : Int,
    @SerializedName("total_pages") val totalPages : Int,
    @SerializedName("results") val results : List<Movie>
)