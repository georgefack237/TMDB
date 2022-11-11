package com.example.tmdb.data.network

import android.util.Log
import com.example.tmdb.data.models.Movie
import com.example.tmdb.data.models.MovieResponse
import com.example.tmdb.utils.apiKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepository {

    private val movieApi: MovieApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    fun getTopRatedMovies(page: Int = 1,
    onSuccess: (movies: List<Movie>)-> Unit,
                          onError:()->Unit){
        movieApi.getTopRated(apiKey, page)
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