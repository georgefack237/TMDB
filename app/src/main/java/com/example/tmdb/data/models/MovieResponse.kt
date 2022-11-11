package com.example.tmdb.data.models

import com.example.tmdb.data.models.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: Long,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_pages") val pages: Int,
)