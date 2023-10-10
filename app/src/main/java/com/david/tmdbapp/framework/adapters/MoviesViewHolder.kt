package com.david.tmdbapp.framework.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.david.tmdbapp.databinding.ItemMovieBinding
import com.david.tmdbapp.domain.model.Movie
import com.david.tmdbapp.utils.Constants

/*
 * View holder for the RecyclerView that shows the list of movies
 */
class MoviesViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /*
     * Function that binds the data to the view holder
     *
     * @param item: Movie - Movie to be shown
     * @param context: Context - Context of the activity
     */
    fun bind(item: Movie, context: Context) {
        val movieTitle = item.title
        val movieOverview = item.overview
        val movieOverviewShort = movieOverview.substring(0, 100) + "..."
        val movieImageSrc = "${Constants.IMAGE_BASE_URL}${item.poster_path}"
        binding.movieName.text = movieTitle
        binding.movieOverview.text = movieOverviewShort

        Glide.with(context).load(movieImageSrc).into(binding.moviePhoto)
    }
}