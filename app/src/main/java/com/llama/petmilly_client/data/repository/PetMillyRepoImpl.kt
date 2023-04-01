package com.llama.petmilly_client.data.repository

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.findmypet.findmypetdetail.FindMyPetDetailDTO
import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.model.locationauthenticationResponse.LocationauthenticationResponse
import com.llama.petmilly_client.data.model.moveservice.moveservicedetail.MoveServiceDetailDTO
import com.llama.petmilly_client.data.model.moveservice.patchmoveservicepost.patchmoveservicepostResponse
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.MoveServicePostDTO
import com.llama.petmilly_client.data.model.post.postdto.PostDTO
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionDTO
import com.llama.petmilly_client.data.model.temporary.detail.TemporarydetailDTO
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
        charmAppeal: RequestBody,
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
        startReceptionPeriod: RequestBody?,
        endReceptionPeriod: RequestBody?,
        temporaryProtectionCondition: List<RequestBody>?,
        temporaryProtectionHope: List<RequestBody>?,
        temporaryProtectionNo: List<RequestBody>?,

        ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.posttemporaryprotection(
            token,
            files,
            charmAppeal,
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
            startReceptionPeriod,
            endReceptionPeriod,
            temporaryProtectionCondition,
            temporaryProtectionHope,
            temporaryProtectionNo
        )
    }

    override suspend fun posttownauth(
        token: String,
        locationauthenticationResponse: LocationauthenticationResponse,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.posttownauth(token, locationauthenticationResponse)
    }

    override suspend fun getpost(
        token: String,
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: List<String>?,
        type: String,
    ): RemoteResult<PostDTO> = getResult {
        petMillYApiService.getpost(token, page, limit, cat, dog, isComplete, weight, type)
    }


    override suspend fun gettemporarydetail(
        token: String,
        id: Int,
    ): RemoteResult<TemporarydetailDTO> = getResult {
        petMillYApiService.gettemporarydetail(token, id)
    }

    override suspend fun posttemporaryphoto(
        token: String,
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryprotectionDTO> =getResult{
        petMillYApiService.posttemporaryphoto(token, id, files)
    }

    override suspend fun patchtemporary(
        token: String,
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.patchtemporary(token, id)
    }

    override suspend fun deletetemporary(
        token: String,
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO> =getResult{
        petMillYApiService.deletetemporary(token, id)
    }

    override suspend fun postmoveservicepost(
        token: String,
        startAddress: RequestBody,
        endAddress: RequestBody,
        animalTypes: RequestBody,
        name: RequestBody,
        gender: RequestBody,
        weight: RequestBody,
        breed: RequestBody,
        age: RequestBody,
        etc: RequestBody,
        hopeDate: RequestBody,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.postmoveservicepost(token, startAddress, endAddress, animalTypes, name, gender, weight, breed, age, etc, hopeDate, files)
    }

    override suspend fun getmoveservicepost(
        token: String,
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: String?,
        type: String,
    ): RemoteResult<MoveServicePostDTO> = getResult {
        petMillYApiService.getmoveservicepost(
            token,
            page,
            limit,
            cat,
            dog,
            isComplete,
            weight,
            type
        )
    }

    override suspend fun getmoveservicepostdetail(
        token: String,
        id: Int,
    ): RemoteResult<MoveServiceDetailDTO> = getResult {
        petMillYApiService.getmoveservicepostdetail(token, id)
    }

    override suspend fun postmoveservicephoto(
        token: String,
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.postmoveservicephoto(token, id,files)
    }

    override suspend fun patchmoveservicepost(
        token: String,
        id: Int,
        patchmoveservicepostResponse: patchmoveservicepostResponse,
    ): RemoteResult<TemporaryprotectionDTO> = getResult{
        petMillYApiService.patchmoveservicepost(token, id, patchmoveservicepostResponse)
    }

    override suspend fun deletemoveservicepost(
        token: String,
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult{
        petMillYApiService.deletemoveservicepost(token, id)
    }

    override suspend fun deletemoveservicephoto(
        token: String,
        id: Int,
        photoId: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult{
        petMillYApiService.deletetemporaryphoto(token, id, photoId)
    }

    override suspend fun postfindmypet(
        token: String,
        files: List<MultipartBody.Part>?,
        animalTypes: RequestBody,
        name: RequestBody,
        gender: RequestBody,
        weight: RequestBody,
        breed: RequestBody,
        age: RequestBody,
        missingDate: RequestBody,
        missingAddress: RequestBody,
        clothes: RequestBody?,
        lead: RequestBody?,
        etc: RequestBody?,
        isPublic: RequestBody,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
        petMillYApiService.postfindmypet(token, files, animalTypes, name, gender, weight, breed, age, missingDate, missingAddress, clothes, lead, etc, isPublic)
    }

    override suspend fun postfindmypetcomment(
        token: String,
        id: Int,
        files: List<MultipartBody.Part>?,
        sightingAddress: RequestBody,
        comment: RequestBody,
        sightingDate: RequestBody,
    ): RemoteResult<TemporaryprotectionDTO> = getResult{
        petMillYApiService.postfindmypetcomment(token, id, files, sightingAddress, comment, sightingDate)
    }

    override suspend fun getfindmypetdetail(
        token: String,
        id: Int,
    ): RemoteResult<FindMyPetDetailDTO> = getResult {
        petMillYApiService.getfindmypetdetail(token, id)
    }

    override suspend fun deletefindmypetcomment(
        token: String,
        id: Int,
        commentId: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult {
       petMillYApiService.deletefindmypetcomment(token, id, commentId)
    }

    override suspend fun deletefindpetpost(
        token: String,
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO> = getResult{
        petMillYApiService.deletefindpetpost(token, id)
    }


}