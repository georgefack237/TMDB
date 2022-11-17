package com.example.tmdb.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.tmdb.R
import com.example.tmdb.data.models.Movie
import com.example.tmdb.utils.TMDBConstants

class MovieAdapter(private var movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    fun updateMovie (movies: List<Movie>){
        this.movies = movies
        notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


        private val image: ImageView = itemView.findViewById(R.id.movieImage)
        private val title: TextView = itemView.findViewById(R.id.movieTitle)
        private val rating:RatingBar = itemView.findViewById(R.id.movieRating)


        fun bind(movie: Movie){

            Glide.with(itemView)
                .load("${TMDBConstants.IMAGE_URL}${movie.posterPath}").apply (RequestOptions().transform(
                    CenterCrop(), RoundedCorners(20)
                ))
                .transform(CenterCrop())
                .into(image)

            title.text = movie.title
            rating.rating = movie.rating / 12

        }
    }
}