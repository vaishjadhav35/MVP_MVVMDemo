package com.example.myapplication.feature.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.feature.movies.MovieDetails

class MovieGenreListAdapter(
    private var movieDetails: MovieDetails
):
    RecyclerView.Adapter<ListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_movie_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieDetails.genre.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        return holder.bind(movieDetails.genre[position])

    }
}

class ListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val genre: TextView = itemView.findViewById(R.id.movieGenre)
    fun bind(movie: String) {
        genre.text = "Genre: ${movie}"

    }
}
