package com.david.tmdbapp.framework.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.david.tmdbapp.databinding.ItemMovieBinding
import com.david.tmdbapp.domain.model.Movie
import com.david.tmdbapp.utils.Constants

class MoviesViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie, context: Context) {
        val movieTitle = item.title
        val movieImageSrc = "${Constants.IMAGE_BASE_URL}${item.poster_path}"
        binding.TVName.text = movieTitle

        Glide.with(context).load(movieImageSrc).into(binding.moviePhoto)
    }
}