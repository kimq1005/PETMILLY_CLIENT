package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.NewsDTO
import llama.test.jetpack_dagger_plz.data.model.testdto.NewsTestDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "436a7b507ee5433bafa1ad67c8eff93b"
    ): Response<NewsDTO>

    //    https://newsapi.org/v2/everything?q=tesla&from=2022-12-14&sortBy=publishedAt&apiKey=ac48448863594c599d7ff02d3a7a02e1
    @GET("everything")
    suspend fun getNewsEveryThing(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsTestDTO>

}