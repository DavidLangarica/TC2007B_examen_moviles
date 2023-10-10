package com.david.tmdbapp.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.david.tmdbapp.databinding.ItemMovieBinding
import com.david.tmdbapp.domain.model.Movie

class MoviesAdapter: RecyclerView.Adapter<MoviesViewHolder>() {
    var data: ArrayList<Movie> = ArrayList()
    lateinit var context: Context

    fun CompanyReviewAdapter(basicData: ArrayList<Movie>, context: Context) {
        this.data = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}