package com.example.movielist.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.database.MovieRepository
import com.example.movielist.model.Movie
import com.example.movielist.model.MovieResponseObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListActivityViewModel() : ViewModel() {
    private val repository = MovieRepository()
    var movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    fun getMovieData(yearRequested: Int) {
        repository.getMoviesFromDatabase(yearRequested)
            .enqueue(object : Callback<MovieResponseObject> {

                override fun onFailure(call: Call<MovieResponseObject>, t: Throwable) {
                    error.value = t.message.toString()
                }

                override fun onResponse(
                    call: Call<MovieResponseObject>,
                    response: Response<MovieResponseObject>
                ) {
                    if (response.isSuccessful) response.body()?.let {
                        movies.value = it.results
                    }
                    else error.value.apply {
                        "There was an error while retrieving the data \n${response.errorBody()
                            .toString()}"
                    }
                }
            })
    }
}