package com.llama.petmilly_client.data.di

import com.llama.petmilly_client.data.di.DataModule.BASE_URL
import com.llama.petmilly_client.data.network.ApiService
import com.llama.petmilly_client.data.network.LibraryApiService
import com.llama.petmilly_client.data.network.PetMillYApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import llama.test.jetpack_dagger_plz.utils.BaseDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

//    val BASE_URL = "http://localhost:3000/"
    val BASE_URL = "http://192.168.0.44:3000/"
//    val BASE_URL = "http://172.30.1.98:3000/"



    //10.0.2.2:8080

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .build()


    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun LibraryApiSerVice(): LibraryApiService {
        return Retrofit.Builder()
            .baseUrl("http://openapi.seoul.go.kr:8088/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LibraryApiService::class.java)
    }

    @Provides
    fun PetMillYApiService(): PetMillYApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(PetMillYApiService::class.java)
    }


}
