package com.example.movielist.database

import com.example.movielist.model.Movie
import com.example.movielist.model.MovieResponseObject
import retrofit2.Call

class MovieRepository(){
    private val movieApi: MovieApiService = MovieApi.createApi()
    private var stringUrl = "3/discover/movie?api_key=75b13d6bdeeadc9717d484f7764064ce&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_year="

    fun getMoviesFromDatabase(yearRequested: Int): Call<MovieResponseObject> {
        stringUrl += yearRequested.toString()
        return movieApi.getMovieList(stringUrl)
    }
}