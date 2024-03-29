package com.example.apicallapp.network

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.apicallapp.models.TopNewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsManager {

    private val _newsResponse = mutableStateOf(TopNewsResponse())
    val newsResponse : State<TopNewsResponse>
        @Composable get() = remember {
            _newsResponse
        }

    init {
        getArticals()
    }

    private fun getArticals(){
        val service = Api.retrofitService.getTopArticals("in",Api.API_KEY)

        service.enqueue(object : Callback<TopNewsResponse>{
            override fun onResponse(
                call: Call<TopNewsResponse>,
                response: Response<TopNewsResponse>
            ) {
                if(response.isSuccessful){
                    _newsResponse.value = response.body()!!
                    Log.d("Success", "${_newsResponse.value}")
                }else{
                    Log.d("error", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<TopNewsResponse>, t: Throwable) {
                Log.d("error", t.stackTrace.toString())
            }

        })
    }


}