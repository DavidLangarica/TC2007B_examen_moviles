package com.david.tmdbapp.data

import NetworkModuleDI
import com.david.tmdbapp.domain.model.tmdbObject

class TmdbAPIClient {
    private lateinit var api: TmdbAPIService

    suspend fun getPokemonList(limit: Int): tmdbObject? {
        api = NetworkModuleDI()
        return try {
            api.getMoviesList()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}