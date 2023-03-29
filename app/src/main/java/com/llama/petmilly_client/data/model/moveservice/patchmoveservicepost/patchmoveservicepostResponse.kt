package com.llama.petmilly_client.data.model.moveservice.patchmoveservicepost

data class patchmoveservicepostResponse(
    val addHopeDate: List<String>,
    val age: Int,
    val animalTypes: String,
    val breed: String,
    val deleteHopeDate: List<Int>,
    val endAddress: String,
    val etc: String,
    val gender: String,
    val name: String,
    val startAddress: String,
    val updateHopeDate: List<UpdateHopeDate>,
    val weight: Int
):java.io.Serializable