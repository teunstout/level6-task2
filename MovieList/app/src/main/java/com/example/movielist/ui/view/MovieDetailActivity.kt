package com.example.movielist.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.movielist.R
import com.example.movielist.model.Movie
import kotlinx.android.synthetic.main.movie_advanced.*
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_advanced)

        initView()
    }

    private fun initView() {
        val movie = intent.getParcelableExtra<Movie>(MOVIE_INTENT)

        movie?.let { letMovie ->
            Glide.with(this).load(letMovie.getBackdropUrl()).into(imgBackdrop)
            Glide.with(this).load(letMovie.getPosterUrl()).into(imgMovie)
            tvTitle.text = letMovie.title
            tvRelease.text = getString(R.string.releaseDate, letMovie.releaseDate)
            tvRating.text = letMovie.rating.toString()
            tvDescription.text = letMovie.descriptionMovie
        } ?: kotlin.run {
            Log.e("movie_not_found", "No movie found")
            finish() }
    }

    companion object {
        const val MOVIE_INTENT = "MOVIE_INTENT"
    }
}
