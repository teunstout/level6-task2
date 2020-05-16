package com.example.movielist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movielist.R
import com.example.movielist.model.Movie
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.movie_list_main.*

class MovieListActivity : AppCompatActivity() {
    private var movies = arrayListOf<Movie>()
    private lateinit var viewModel: MovieListActivityViewModel
    private val adapter = MovieAdapter(movies)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_list_main)

        initView()
    }

    private fun initView() {
        rvMovies.layoutManager = GridLayoutManager(this, 2)
        rvMovies.adapter = adapter

        btnSubmit.setOnClickListener { getMoviesFromDatabase() }
        initViewModel()
    }

    private fun getMoviesFromDatabase() {
        val year = etNumber.text
        if (year.length != 4) {
            Toast.makeText(this, "Please fill in a correct year", Toast.LENGTH_SHORT).show()
            return
        }

        viewModel.getMovieData(etNumber.text.toString().toInt())

    }

    private fun initViewModel() {
        // Initialize the MainActivityViewModel.
        viewModel = ViewModelProvider(this).get(MovieListActivityViewModel::class.java)

        // Observe the trivia object.
        viewModel.movies.observe(this, Observer {
            movies.clear()
            movies.addAll(it)
            adapter.notifyDataSetChanged()
        })

        // Observe the error message.
        viewModel.error.observe(this, Observer {
            Log.e("Error", it)
        })
    }
}
