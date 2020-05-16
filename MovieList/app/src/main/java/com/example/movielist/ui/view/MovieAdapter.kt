package com.example.movielist.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.R
import com.example.movielist.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(val movies: List<Movie>, private val startIntent: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init { itemView.setOnClickListener { startIntent(movies[adapterPosition]) } }

        fun bind(movie: Movie, position: Int) {
            val pos = "${position}."
            itemView.tvPlaceNumber.text = pos
            Glide.with(context).load(movie.getPosterUrl()).into(itemView.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(movies[position], position)
}