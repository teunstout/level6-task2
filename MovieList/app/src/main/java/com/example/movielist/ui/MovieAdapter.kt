package com.example.movielist.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.R
import com.example.movielist.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(val movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie, position: Int){
           itemView.tvPlaceNumber.text = "${position}."
            Glide.with(context).load(movie.getPosterUrl()).into(itemView.imageView)
            Log.i("image", movie.getPosterUrl())
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) = holder.bind(movies[position], position)
}