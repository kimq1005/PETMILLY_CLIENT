package com.llama.petmilly_client.data.model.moveservice.postmoveservice

data class MoveServicePostList(
    val endAddress: String,
    val gender: String,
    val hopeDate: List<HopeDate>?,
    val age:Int,
    val id: Int,
    val isComplete: Boolean,
    val name: String,
    val startAddress: String,
    val thumbnail: Thumbnail,
    val weight: Int
)