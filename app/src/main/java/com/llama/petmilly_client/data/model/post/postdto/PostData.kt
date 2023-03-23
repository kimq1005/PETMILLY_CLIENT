package com.llama.petmilly_client.data.model.post.postdto

data class PostData (
    val age: Double,
    val breed: String,
    val createdAt: String,
    val gender: String,
    val id: Int,
    val inoculation: String,
    val isComplete: Boolean,
    val isReceipt: Boolean,
    val name: String,
    val neutered: String,
    val thumbnail: Thumbnail?,
    val weight: Int
)