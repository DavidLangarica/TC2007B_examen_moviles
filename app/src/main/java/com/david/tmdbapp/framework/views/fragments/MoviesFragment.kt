package com.david.tmdbapp.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.david.tmdbapp.R
import com.david.tmdbapp.databinding.FragmentMoviesBinding
import com.david.tmdbapp.domain.model.Movie
import com.david.tmdbapp.framework.adapters.MoviesAdapter
import com.david.tmdbapp.framework.viewmodels.MoviesViewModel

class MoviesFragment : Fragment() {
    private var _binding: FragmentMoviesBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: MoviesViewModel
    private lateinit var recyclerView: RecyclerView
    private val adapter: MoviesAdapter = MoviesAdapter()
    private lateinit var data: ArrayList<Movie>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        data = ArrayList()
        val apiKey = getString(R.string.TMDB_API_KEY)

        viewModel.getMoviesList(apiKey)

        initializeComponents(root)
        initializeObservers()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents(root: View) {
        recyclerView = root.findViewById(R.id.rv_movies)
    }

    private fun initializeObservers() {
        viewModel.moviesObjectLiveData.observe(viewLifecycleOwner) { tmdbObject ->
            if (tmdbObject != null) {
                setUpRecyclerView(tmdbObject.results as ArrayList<Movie>)
            }
        }
    }

    private fun setUpRecyclerView(dataForList: ArrayList<Movie>) {
        recyclerView.setHasFixedSize(true)
        val dataSize = dataForList.size
        val gridLayoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = gridLayoutManager
        if (dataSize > 0) {
            showMovies()
            adapter.CompanyReviewAdapter(dataForList, requireContext())
            recyclerView.adapter = adapter
        }
    }

    private fun showMovies() {
        binding.rvMovies.visibility = View.VISIBLE
    }
}