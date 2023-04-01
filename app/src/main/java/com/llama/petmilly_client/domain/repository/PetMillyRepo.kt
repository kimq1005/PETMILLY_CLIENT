package com.llama.petmilly_client.domain.repository

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
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

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
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun posttownauth(
        token: String,
        locationauthenticationResponse: LocationauthenticationResponse,
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun getpost(
        token: String,
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: List<String>?,
        type: String,
    ): RemoteResult<PostDTO>


    suspend fun gettemporarydetail(
        token: String,
        id: Int,
    ): RemoteResult<TemporarydetailDTO>

    suspend fun posttemporaryphoto(
        token: String,
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun patchtemporary(
        token: String,
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun deletetemporary(
        token: String,
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun postmoveservicepost(
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
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun getmoveservicepost(
        token: String,
        page: Int?,
        limit: Int?,
        cat: Boolean?,
        dog: Boolean?,
        isComplete: Boolean?,
        weight: String?,
        type: String,
    ): RemoteResult<MoveServicePostDTO>


    suspend fun getmoveservicepostdetail(
        token: String,
        id: Int,
    ): RemoteResult<MoveServiceDetailDTO>

    suspend fun postmoveservicephoto(
        token: String,
        id: Int,
        files: List<MultipartBody.Part>?,
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun patchmoveservicepost(
        token: String,
        id: Int,
        patchmoveservicepostResponse: patchmoveservicepostResponse,
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun deletemoveservicepost(
        token: String,
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO>

    suspend fun deletemoveservicephoto(
        token: String,
        id: Int,
        photoId: Int,
    ): RemoteResult<TemporaryprotectionDTO>


    suspend fun postfindmypet(
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
    ): RemoteResult<TemporaryprotectionDTO>


    //우리 아이 찾아요 게시글 댓글 작성
    suspend fun postfindmypetcomment(
        token: String,
        id: Int,
        files: List<MultipartBody.Part>?,
        sightingAddress: RequestBody,
        comment: RequestBody,
        sightingDate: RequestBody,
    ): RemoteResult<TemporaryprotectionDTO>

    //우리 아이 찾아요 게시글 상세 조회
    suspend fun getfindmypetdetail(
        token: String,
        id: Int,
    ): RemoteResult<FindMyPetDetailDTO>


    //우리 아이 찾아요 댓글 삭제
    suspend fun deletefindmypetcomment(
        token: String,
        id: Int,
        commentId: Int,
    ): RemoteResult<TemporaryprotectionDTO>

    //우리 아이 찾아요 게시글 삭제
    suspend fun deletefindpetpost(
        token: String,
        id: Int,
    ): RemoteResult<TemporaryprotectionDTO>


}