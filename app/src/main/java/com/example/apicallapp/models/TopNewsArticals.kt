package com.example.apicallapp.models

data class TopNewsArticals (
    val source: TopNewsArticalSource,
    val author: String? = null,
    val title: String,
    val description: String? = null,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String? = null
)
