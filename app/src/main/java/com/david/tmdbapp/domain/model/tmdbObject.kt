package com.david.tmdbapp.domain.model

data class tmdbObject(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)