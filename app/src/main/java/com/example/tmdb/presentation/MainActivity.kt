package com.example.tmdb.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.data.models.Movie
import com.example.tmdb.data.repository.remote.MovieRepository
import com.example.tmdb.presentation.adapters.MovieAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MovieAdapter(listOf())

        MovieRepository.getTopRatedMovies(
            onSuccess =::fetchMovies,
            onError = ::onError
        )

        recyclerView = findViewById(R.id.movieList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }

    fun fetchMovies(movies: List<Movie>){
        adapter.updateMovie(movies)
    }

    fun  onError(){

    }
}