package com.llama.petmilly_client.domain.repository

import com.llama.petmilly_client.domain.model.Article
import com.llama.petmilly_client.domain.model.ArticleTest

interface GetNewsArticleRepo {

    suspend fun getNewsArticles() : List<Article>

    suspend fun getNewsEveryThing(q:String, apikey:String) : List<ArticleTest>
}