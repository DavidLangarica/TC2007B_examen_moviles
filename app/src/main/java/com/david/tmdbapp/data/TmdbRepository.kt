package com.david.tmdbapp.data

import com.david.tmdbapp.domain.model.tmdbObject

/*
 * Class that makes the request to the API
 */
class TmdbRepository {
    private val apiTmdb = TmdbAPIClient()

    /*
     * Function that makes the request to the API
     *
     * @param apiKey: String
     * @return tmdbObject?
     */
    suspend fun getMoviesList(apiKey: String): tmdbObject? = apiTmdb.getMoviesList(apiKey)
}