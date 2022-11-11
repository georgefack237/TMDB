package com.example.tmdb.data.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val id: Long,
    @SerializedName("original_name") val title: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("popularity") val rating: Float,
)