package com.llama.petmilly_client.data.repository


import com.llama.petmilly_client.data.mappers.toDomain
import com.llama.petmilly_client.data.mappers.toTestDomain
import com.llama.petmilly_client.data.network.ApiService
import com.llama.petmilly_client.domain.model.Article
import com.llama.petmilly_client.domain.model.ArticleTest
import com.llama.petmilly_client.domain.repository.GetNewsArticleRepo
import llama.test.jetpack_dagger_plz.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsArticleRepoImpl @Inject constructor(private val apiService: ApiService) :
    GetNewsArticleRepo, SafeApiRequest() {
    override suspend fun getNewsArticles(): List<Article> {
        val response = safeApiRequest { apiService.getNewsArticles() }
        return response?.articles?.toDomain()!!
    }

    override suspend fun getNewsEveryThing(q: String, apikey: String): List<ArticleTest> {
        val response = safeApiRequest { apiService.getNewsEveryThing(q,apikey) }
        return response.articleTestDTOS.toTestDomain()
    }

}