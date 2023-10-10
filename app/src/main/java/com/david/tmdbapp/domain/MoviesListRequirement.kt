package com.david.tmdbapp.domain

import android.util.Log
import com.david.tmdbapp.data.TmdbRepository
import com.david.tmdbapp.domain.model.tmdbObject

class MoviesListRequirement() {
    private val repository = TmdbRepository()
    suspend operator fun invoke(apiKey: String): tmdbObject? {
        return repository.getMoviesList(apiKey)
    }
}