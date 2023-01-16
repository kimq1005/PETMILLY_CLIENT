package com.llama.petmilly_client.data.model


import com.llama.petmilly_client.data.model.ArticleDTO


data class NewsDTO(
    val articles: List<ArticleDTO>?,
    val status: String?,
    val totalResults: Int?
)