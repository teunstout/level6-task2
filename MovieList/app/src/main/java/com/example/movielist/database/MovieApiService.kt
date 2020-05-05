package com.example.movielist.database

import com.example.movielist.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MovieApiService {

    @GET
    fun getMovieList(@Url stringUrl: String): Call<List<Movie>> // Call = async action with callback and queue
}