package com.llama.petmilly_client.data.model.temporary

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Part
import retrofit2.http.Query

data class TemporaryprotectionResponse(
    @Part val files: List<MultipartBody.Part>?,
    @Part ("animalTypes") val animalTypes : RequestBody,
    @Part("name") val name: RequestBody,
    @Part ("gender") val gender : RequestBody,
    @Part ("weight") val weight : RequestBody,
    @Part ("breed") val breed : RequestBody,
    @Part ("age") val age : RequestBody,
    @Part ("neutered") val neutered : RequestBody,
    @Part ("inoculation") val inoculation : RequestBody,
    @Part ("health") val health : RequestBody,
    @Part ("skill") val skill : RequestBody,
    @Part ("character") val character : RequestBody,
    @Part ("pickUp") val pickUp : RequestBody,
    @Part ("receptionPeriod") val receptionPeriod : RequestBody,
    @Part("temporaryProtectionCondition") val temporaryProtectionCondition: List<RequestBody>,
    @Part("temporaryProtectionHope") val temporaryProtectionHope: List<RequestBody>,
    @Part("temporaryProtectionNo") val temporaryProtectionNo: List<RequestBody>
):java.io.Serializable


