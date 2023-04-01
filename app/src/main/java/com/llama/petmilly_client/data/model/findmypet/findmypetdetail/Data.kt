package com.llama.petmilly_client.data.model.findmypet.findmypetdetail

data class Data(
    val age: Int,
    val animalTypes: String,
    val breed: String,
    val clothes: String,
    val comment: List<Comment>,
    val completeUser: CompleteUser,
    val createdAt: String,
    val etc: String,
    val gender: String,
    val id: Int,
    val isComplete: Boolean,
    val isDeleted: Boolean,
    val isPublic: Boolean,
    val lead: String,
    val missingAddress: String,
    val missingDate: String,
    val name: String,
    val photoUrls: List<PhotoUrl>,
    val updatedAt: String,
    val user: User,
    val weight: Int
)