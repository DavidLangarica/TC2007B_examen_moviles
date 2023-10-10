package com.david.tmdbapp.data

import com.david.tmdbapp.domain.model.tmdbObject
import retrofit2.http.GET

/*
 * Interface that defines the API endpoints
 */
interface TmdbAPIService {
    /*
     * Function that makes the request to the API
     *
     * @return tmdbObject
     */
    @GET("popular")
    suspend fun getMoviesList(): tmdbObject
}