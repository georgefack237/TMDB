package com.example.tmdb.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.data.models.Category
import com.example.tmdb.data.models.categories

class CategoryAdapter(categories: List<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount() = categories.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val title: TextView = itemView.findViewById(R.id.categoryTitle)
        val emoji : TextView = itemView.findViewById(R.id.emojiView)

        fun bind(category: Category){
            val em: String =getEmojiByUnicode(category.emoji)
            title.text = category.title
            emoji.text = em
        }


        private fun getEmojiByUnicode(unicode: Int): String {
            return String(Character.toChars(unicode))
        }
    }
}