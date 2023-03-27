package com.llama.petmilly_client.data.model.moveservice.postmoveservice

data class Data(
    val limit: Int,
    val list: List<MoveServicePostList>,
    val page: Int,
    val type: String
)