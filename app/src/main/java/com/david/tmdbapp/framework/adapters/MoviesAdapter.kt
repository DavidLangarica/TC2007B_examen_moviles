package com.david.tmdbapp.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.david.tmdbapp.databinding.ItemMovieBinding
import com.david.tmdbapp.domain.model.Movie

/*
 * Adapter for the RecyclerView that shows the list of movies
 */
class MoviesAdapter: RecyclerView.Adapter<MoviesViewHolder>() {
    var data: ArrayList<Movie> = ArrayList()
    lateinit var context: Context

    /*
     * Function that sets the data for the adapter
     *
     * @param basicData: ArrayList<Movie> - List of movies to be shown
     * @param context: Context - Context of the activity
     */
    fun CompanyReviewAdapter(basicData: ArrayList<Movie>, context: Context) {
        this.data = basicData
        this.context = context
    }

    /*
     * Function that binds the data to the view holder
     *
     * @param holder: MoviesViewHolder
     * @param position: Int
     */
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    /*
     * Function that inflates the view holder
     *
     * @param parent: ViewGroup
     * @param viewType: Int
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    /*
     * Function that returns the size of the data
     *
     * @return Int
     */
    override fun getItemCount(): Int {
        return data.size
    }
}