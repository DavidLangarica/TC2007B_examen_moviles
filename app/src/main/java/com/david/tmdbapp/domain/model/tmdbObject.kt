package com.david.tmdbapp.domain.model

/*
 * Data class that represents the response from the API, contains a list of Movies
 */
data class tmdbObject(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)