package com.example.tmdb.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.tmdb.R
import com.example.tmdb.data.models.Movie
import com.example.tmdb.data.models.categories
import com.example.tmdb.data.repository.remote.MovieRepository
import com.example.tmdb.presentation.adapters.CategoryAdapter
import com.example.tmdb.presentation.adapters.MovieAdapter
import com.example.tmdb.utils.TMDBConstants

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryList: RecyclerView
    private lateinit var adapter: MovieAdapter
    private lateinit var categoryAdapter:CategoryAdapter
    private lateinit var profileImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.movieList)
        categoryList = findViewById(R.id.categories)
        profileImage = findViewById(R.id.profileImage)

        setUpProfile()

        categoryAdapter = CategoryAdapter(categories = categories)
        adapter = MovieAdapter(listOf())

        MovieRepository.getTopRatedMovies(
            onSuccess =::fetchMovies,
            onError = ::onError
        )


        recyclerView.adapter = adapter
        categoryList.adapter = categoryAdapter

        categoryList.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun fetchMovies(movies: List<Movie>){
        adapter.updateMovie(movies)
    }

    private fun  onError(){

    }

    private fun setUpProfile(){
        Glide.with(profileImage)
            .load(TMDBConstants.PROFILE_IMAGE).apply (
                RequestOptions().transform(
                CenterCrop(), RoundedCorners(20)
            ))
            .transform(CenterCrop())
            .into(profileImage)

    }
}