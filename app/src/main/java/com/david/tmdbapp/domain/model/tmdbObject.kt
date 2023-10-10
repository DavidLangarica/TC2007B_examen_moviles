package com.david.tmdbapp.domain.model

import com.google.gson.annotations.SerializedName

data class tmdbObject(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: ArrayList<tmdb>,
)
