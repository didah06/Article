package com.example.testfrontendandroiddeveloper.models

data class News(
    val Articles: List<Article>,
    val status: String,
    val totalResults: Int
)