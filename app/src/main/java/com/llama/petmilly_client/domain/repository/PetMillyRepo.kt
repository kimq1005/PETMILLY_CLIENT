package com.llama.petmilly_client.domain.repository

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.model.locationauthenticationResponse.LocationauthenticationResponse
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionDTO
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Part

interface PetMillyRepo {
    suspend fun postkakaotoken(
        kaKaoResponse: KaKaoResponse,
    ): RemoteResult<KaKaoLoginDTO>

    suspend fun postadditonalinfo(
        token: String,
        additionalResponse: AdditionalResponse,
    ): RemoteResult<AdditionalSuccessDTO>

    suspend fun postuseraccesstoken(
        tokenResponse: TokenResponse,
    ): RemoteResult<AccessTokenDTO>

    suspend fun postuserrefreshtoken(
        tokenResponse: TokenResponse,
    ): RemoteResult<RefreshTokenDTO>

//    suspend fun posttemporaryprotection(
//        token: String,
//        temporaryprotectionResponse: TemporaryprotectionResponse
//    ):RemoteResult<TemporaryprotectionDTO>

    suspend fun posttemporaryprotection(
        token: String,
        files: List<MultipartBody.Part>?,
        animalTypes: RequestBody,
        name: RequestBody,
        gender: RequestBody,
        weight: RequestBody,
        breed: RequestBody,
        age: RequestBody,
        neutered: RequestBody,
        inoculation: RequestBody,
        health: RequestBody?,
        skill: RequestBody?,
        character: RequestBody?,
        pickUp: RequestBody,
        receptionPeriod: RequestBody?,
        temporaryProtectionCondition: List<RequestBody>?,
        temporaryProtectionHope: List<RequestBody>?,
        temporaryProtectionNo: List<RequestBody>?,
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun posttownauth(
        token: String,
        locationauthenticationResponse: LocationauthenticationResponse,
    ): RemoteResult<TemporaryprotectionDTO>
}