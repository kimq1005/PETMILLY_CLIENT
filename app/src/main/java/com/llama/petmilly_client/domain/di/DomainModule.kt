package com.llama.petmilly_client.domain.di

import com.llama.petmilly_client.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.llama.petmilly_client.data.repository.GetNewsArticleRepoImpl
import com.llama.petmilly_client.data.repository.TestRepoImpl
import com.llama.petmilly_client.domain.repository.GetNewsArticleRepo
import com.llama.petmilly_client.domain.repository.TestRepo

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetNewRepo(apiService: ApiService) : GetNewsArticleRepo {
        return GetNewsArticleRepoImpl(apiService)
    }

    @Provides
    fun provideTestRepo(apiService: ApiService) : TestRepo {
        return TestRepoImpl(apiService)
    }

}