package com.llama.petmilly_client.data.model.post.postdto

data class Data(
    val limit: Int,
    val list: List<PostData>,
    val page: Int,
    val type: String
)