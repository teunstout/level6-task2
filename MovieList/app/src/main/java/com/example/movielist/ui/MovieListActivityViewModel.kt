package com.example.movielist.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.database.MovieRepository
import com.example.movielist.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListActivityViewModel() : ViewModel() {
    private val repository = MovieRepository()
    var movies = MutableLiveData<ArrayList<Movie>>()
    val error = MutableLiveData<String>()

    fun getMovieData(yearRequested: Int) {
        repository.getMoviesFromDatabase(yearRequested)
            .enqueue(object : Callback<List<Movie>> {

                override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                    if (response.isSuccessful) movies.value.apply { response.body() }
                    else error.value.apply {
                        "There was an error while retrieving the data \n${response.errorBody()
                            .toString()}"
                    }
                }

                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                    error.value = t.message.toString()
                }

            })
    }
}