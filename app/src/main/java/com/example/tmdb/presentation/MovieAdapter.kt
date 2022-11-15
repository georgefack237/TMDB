package com.example.tmdb.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.tmdb.R
import com.example.tmdb.data.models.Movie

class MovieAdapter(private var movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
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
        private val rating: TextView = itemView.findViewById(R.id.movieRating)

        fun bind(movie: Movie){

            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                .transform(CenterCrop())
                .into(image)

            title.text = movie.title
            rating.text = movie.rating.toString()

        }
    }
}