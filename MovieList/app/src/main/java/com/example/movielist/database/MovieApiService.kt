package com.example.movielist.database

import com.example.movielist.model.MovieResponseObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MovieApiService {

    @GET
    fun getMovieList(@Url stringUrl: String): Call<MovieResponseObject> // Call = async action with callback and queue
}