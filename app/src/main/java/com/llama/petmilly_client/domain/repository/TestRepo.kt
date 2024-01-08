package com.llama.petmilly_client.domain.repository

import com.llama.petmilly_client.data.model.NewsDTO
import llama.test.jetpack_dagger_plz.data.model.testdto.NewsTestDTO
import llama.test.jetpack_dagger_plz.utils.RemoteResult

interface TestRepo {
    suspend fun getNewsEveryThing(q:String, apikey:String) : RemoteResult<NewsTestDTO>

    suspend fun getNewsArticles() : RemoteResult<NewsDTO>
}