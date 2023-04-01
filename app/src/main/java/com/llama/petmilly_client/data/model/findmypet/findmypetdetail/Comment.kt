package com.llama.petmilly_client.data.model.findmypet.findmypetdetail

data class Comment(
    val comment: String,
    val createdAt: String,
    val id: Int,
    val isDeleted: Boolean,
    val location: String,
    val photoUrls: List<PhotoUrl>,
    val sightingAddress: String,
    val sightingDate: String,
    val updatedAt: String,
    val user: User
)