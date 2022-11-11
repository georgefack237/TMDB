package com.example.tmdb.data.network

import com.example.tmdb.data.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.tmdb.utils.apiKey

interface MovieApi {

    @GET("tv/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String = "24142a259b6610ee217ed7d0a43d3130",
        @Query("page") page: Int
    ): Call<MovieResponse>
}