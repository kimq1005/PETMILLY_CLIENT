package com.llama.petmilly_client.data.mappers

import com.llama.petmilly_client.data.model.ArticleDTO
import llama.test.jetpack_dagger_plz.data.model.testdto.ArticleTestDTO
import com.llama.petmilly_client.domain.model.Article
import com.llama.petmilly_client.domain.model.ArticleTest

fun List<ArticleDTO>.toDomain() : List<Article>{
    return map{
        Article(
            content = it.content?:"",
            description = it.description?:"",
            title = it.title?:"",
            urlToImage = it.urlToImage?:""
        )
    }
}

fun List<ArticleTestDTO>.toTestDomain() : List<ArticleTest>{
    return map{
        ArticleTest(
            content = it.content ?: "",
            title = it.title ?: ""
        )
    }
}