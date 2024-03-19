package com.example.apicallapp.models

data class TopNewsResponse(
    val status: String? = null,
    val totalResults: Long? = null,
    val articles: List<TopNewsArticals>? = null
)

