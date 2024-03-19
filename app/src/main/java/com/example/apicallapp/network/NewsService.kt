package com.example.apicallapp.network

import com.example.apicallapp.models.TopNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    fun getTopArticals(
        @Query("country") country: String,
//        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ) : Call<TopNewsResponse>

}