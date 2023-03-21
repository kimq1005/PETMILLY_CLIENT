package com.llama.petmilly_client.data.repository

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionDTO
import com.llama.petmilly_client.data.network.PetMillYApiService
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import llama.test.jetpack_dagger_plz.utils.BaseDataSource
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class PetMillyRepoImpl @Inject constructor(private val petMillYApiService: PetMillYApiService) :
    PetMillyRepo, BaseDataSource() {

    override suspend fun postkakaotoken(kaKaoResponse: KaKaoResponse): RemoteResult<KaKaoLoginDTO> =
        getResult {
            petMillYApiService.postkakaotoken(kaKaoResponse)
        }

    override suspend fun postadditonalinfo(
        token: String,
        additionalResponse: AdditionalResponse,
    ): RemoteResult<AdditionalSuccessDTO> = getResult {
        petMillYApiService.postadditonalinfo(token, additionalResponse)
    }

    override suspend fun postuseraccesstoken(tokenResponse: TokenResponse): RemoteResult<AccessTokenDTO> =
        getResult {
            petMillYApiService.postuseraccesstoken(tokenResponse)
        }

    override suspend fun postuserrefreshtoken(tokenResponse: TokenResponse): RemoteResult<RefreshTokenDTO> =
        getResult {
            petMillYApiService.postuserrefreshtoken(tokenResponse)
        }

    override suspend fun posttemporaryprotection(
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
        receptionPeriod: RequestBody??,
        temporaryProtectionCondition: List<RequestBody>?,
        temporaryProtectionHope: List<RequestBody>?,
        temporaryProtectionNo: List<RequestBody>?,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.posttemporaryprotection(
            token,
            files,
            animalTypes,
            name,
            gender,
            weight,
            breed,
            age,
            neutered,
            inoculation,
            health,
            skill,
            character,
            pickUp,
            receptionPeriod,
            temporaryProtectionCondition,
            temporaryProtectionHope,
            temporaryProtectionNo
        )
    }

//    override suspend fun posttemporaryprotection(
//        token: String,
//        temporaryprotectionResponse: TemporaryprotectionResponse,
//    ): RemoteResult<TemporaryprotectionDTO> = getResult {
//        petMillYApiService.posttemporaryprotection(token, temporaryprotectionResponse)
//    }

}