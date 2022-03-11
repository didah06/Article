package com.example.testfrontendandroiddeveloper.api


import com.example.testfrontendandroiddeveloper.models.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("everything")
    fun getArticles(@Query("apiKey") apiKey: String): Call<News>
}