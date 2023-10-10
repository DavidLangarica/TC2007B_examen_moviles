package com.david.tmdbapp.data

import NetworkModuleDI
import com.david.tmdbapp.domain.model.tmdbObject

/*
 * Class that makes the request to the API
 */
class TmdbAPIClient {
    private lateinit var api: TmdbAPIService

    /*
     * Function that makes the request to the API
     *
     * @param apiKey: String
     * @return tmdbObject?
     */
    suspend fun getMoviesList(apiKey: String): tmdbObject? {
        api = NetworkModuleDI(apiKey)
        return try {
            api.getMoviesList()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}