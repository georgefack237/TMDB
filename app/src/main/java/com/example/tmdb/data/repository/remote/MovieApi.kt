package com.example.tmdb.data.repository.remote

import com.example.tmdb.data.models.MovieResponse
import com.example.tmdb.utils.TMDBConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("tv/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String = TMDBConstants.apiKey,
        @Query("page") page: Int
    ): Call<MovieResponse>
}