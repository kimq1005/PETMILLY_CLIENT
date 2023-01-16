package com.llama.petmilly_client.data.repository

import com.llama.petmilly_client.data.model.NewsDTO
import com.llama.petmilly_client.data.network.ApiService
import llama.test.jetpack_dagger_plz.data.model.testdto.NewsTestDTO
import com.llama.petmilly_client.domain.repository.TestRepo
import llama.test.jetpack_dagger_plz.utils.BaseDataSource
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

class TestRepoImpl @Inject constructor(private val apiservice: ApiService)
    : TestRepo, BaseDataSource() {
    override suspend fun getNewsEveryThing(q: String, apikey: String): RemoteResult<NewsTestDTO> =
        getResult {
            apiservice.getNewsEveryThing(q, apikey)
        }

    override suspend fun getNewsArticles(): RemoteResult<NewsDTO> = getResult{
        apiservice.getNewsArticles()
    }

}