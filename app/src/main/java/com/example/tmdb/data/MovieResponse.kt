package com.example.tmdb.data

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: Long,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int,
)