package com.david.tmdbapp.domain

import com.david.tmdbapp.data.TmdbRepository
import com.david.tmdbapp.domain.model.tmdbObject

/*
 * Class that makes the request to the API and represents te use case of showing the list of movies
 */
class MoviesListRequirement() {
    private val repository = TmdbRepository()

    /*
     * Function that makes the request to the API
     *
     * @param apiKey: String
     * @return tmdbObject?
     */
    suspend operator fun invoke(apiKey: String): tmdbObject? {
        return repository.getMoviesList(apiKey)
    }
}