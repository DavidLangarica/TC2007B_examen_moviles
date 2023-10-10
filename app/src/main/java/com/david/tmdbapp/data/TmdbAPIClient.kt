package com.david.tmdbapp.data

import NetworkModuleDI
import com.david.tmdbapp.domain.model.tmdbObject

class TmdbAPIClient {
    private lateinit var api: TmdbAPIService

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