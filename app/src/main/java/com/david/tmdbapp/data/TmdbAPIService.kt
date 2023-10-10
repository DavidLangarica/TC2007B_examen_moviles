package com.david.tmdbapp.data

import com.david.tmdbapp.domain.model.tmdbObject
import retrofit2.http.GET

interface TmdbAPIService {
    @GET("popular")
    suspend fun getMoviesList(): tmdbObject
}