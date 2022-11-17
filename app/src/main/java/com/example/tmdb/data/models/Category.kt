package com.example.tmdb.data.models

data class Category (
    val emoji: Int,
    val title: String
)



val categories = listOf(
    Category( 0x1F631	, "Horror"),
    Category(0x1F92A	, "Comedy"),
    Category(0x1F600, "Sports"),
    Category(0x1F929	, "Drama"),
    Category(0x1F618	, "Romance")
)