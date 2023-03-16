package com.llama.petmilly_client.data.model.additonal.reponse

data class AdditionalResponse(
    val name: String,
    val nickname: String,
    val birthday: String,
    val job: String,
    val companionAnimal: String,
    val companionAnimalCount: String,
    val gender: String,
    val companionAnimalInfo: List<CompanionAnimalInfo>?,
    val temporaryProtection: String,
    val familyInfo: List<FamilyInfo>?,
    val allergy: String,
    val typeOfResidence: String
):java.io.Serializable