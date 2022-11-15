package com.example.tmdb.data.repository.remote

import android.util.Log
import com.example.tmdb.data.models.Movie
import com.example.tmdb.data.models.MovieResponse
import com.example.tmdb.utils.TMDBConstants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepository {

    private val movieApi: MovieApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(TMDBConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    fun getTopRatedMovies(page: Int = 1,
    onSuccess: (movies: List<Movie>)-> Unit,
                          onError:()->Unit){
        movieApi.getTopRated(TMDBConstants.apiKey, page)
            .enqueue(object : Callback<MovieResponse>{

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {

                    if(response.isSuccessful){
                        val responseBody = response.body()

                        if(responseBody != null){
                            onSuccess.invoke(responseBody.movies)
                            Log.e("TAG", "${responseBody.movies}")
                        }else{
                            onError.invoke()
                            Log.e("TAG", "No data found!")
                        }
                    }else{
                        Log.e("TAG", "An error occurred at this ${response}")
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    onError.invoke()
                    Log.e("TAG", "An error occurred at $t")

                }

            })

    }

}