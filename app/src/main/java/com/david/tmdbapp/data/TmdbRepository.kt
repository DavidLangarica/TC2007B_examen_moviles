package com.david.tmdbapp.data

import com.david.tmdbapp.domain.model.tmdbObject

class TmdbRepository {
    private val apiTmdb = TmdbAPIClient()
    suspend fun getMoviesList(apiKey: String): tmdbObject? = apiTmdb.getMoviesList(apiKey)
}