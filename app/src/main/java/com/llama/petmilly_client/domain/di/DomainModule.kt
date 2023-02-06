package com.llama.petmilly_client.domain.di

import com.llama.petmilly_client.data.network.ApiService
import com.llama.petmilly_client.data.network.LibraryApiService
import com.llama.petmilly_client.data.network.PetMillYApiService
import com.llama.petmilly_client.data.repository.GetLibraryRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.llama.petmilly_client.data.repository.GetNewsArticleRepoImpl
import com.llama.petmilly_client.data.repository.PetMillyRepoImpl
import com.llama.petmilly_client.data.repository.TestRepoImpl
import com.llama.petmilly_client.domain.repository.GetLibraryRepo
import com.llama.petmilly_client.domain.repository.GetNewsArticleRepo
import com.llama.petmilly_client.domain.repository.PetMillyRepo
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

    @Provides
    fun provideLibraryRepo(libraryServcie:LibraryApiService) : GetLibraryRepo{
        return GetLibraryRepoImpl(libraryServcie)
    }

    @Provides
    fun providePetMillyRepo(petMillYApiService: PetMillYApiService) : PetMillyRepo{
        return PetMillyRepoImpl(petMillYApiService)
    }

}