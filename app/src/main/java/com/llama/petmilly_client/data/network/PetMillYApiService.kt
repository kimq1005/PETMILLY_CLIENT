package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.model.locationauthenticationResponse.LocationauthenticationResponse
import com.llama.petmilly_client.data.model.moveservice.postmoveservice.MoveServicePostDTO
import com.llama.petmilly_client.data.model.post.postdto.PostDTO
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionResponse
import com.llama.petmilly_client.data.model.temporary.detail.TemporarydetailDTO
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface PetMillYApiService {

    @POST("user/kakao-sign-in")
    suspend fun postkakaotoken(
        @Body kaKaoResponse: KaKaoResponse,
    ): Response<KaKaoLoginDTO>

    @POST("user/additional-info")
    suspend fun postadditonalinfo(
        @Header("x-access-token") token: String,
        @Body additionalResponse: AdditionalResponse,
    ): Response<AdditionalSuccessDTO>

    @POST("user/reissuance-access-token")
    suspend fun postuseraccesstoken(
        @Body tokenResponse: TokenResponse,
    ): Response<AccessTokenDTO>

    @POST("user/reissuance-refresh-token")
    suspend fun postuserrefreshtoken(
        @Body tokenResponse: TokenResponse,
    ): Response<RefreshTokenDTO>

//    @POST("post/temporary-protection")
//    suspend fun posttemporaryprotection(
//        @Header("x-access-token") token: String,
//        @Body temporaryprotectionResponse: TemporaryprotectionResponse
//    ):Response<TemporaryprotectionDTO>

    @POST("post/temporary-protection")
    @Multipart
    @JvmSuppressWildcards
    suspend fun posttemporaryprotection(
        @Header("x-access-token") token: String,
        @Part files: List<MultipartBody.Part>?,
        @Part("charmAppeal") charmAppeal :RequestBody,
        @Part("animalTypes") animalTypes: RequestBody,
        @Part("name") name: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("weight") weight: RequestBody,
        @Part("breed") breed: RequestBody,
        @Part("age") age: RequestBody,
        @Part("neutered") neutered: RequestBody,
        @Part("inoculation") inoculation: RequestBody,
        @Part("health") health: RequestBody?,
        @Part("skill") skill: RequestBody?,
        @Part("character") character: RequestBody?,
        @Part("pickUp") pickUp: RequestBody,
        @Part("startReceptionPeriod") startReceptionPeriod: RequestBody?,
        @Part("endReceptionPeriod") endReceptionPeriod: RequestBody?,
        @Part("temporaryProtectionCondition") temporaryProtectionCondition: List<RequestBody>?,
        @Part("temporaryProtectionHope") temporaryProtectionHope: List<RequestBody>?,
        @Part("temporaryProtectionNo") temporaryProtectionNo: List<RequestBody>?,
    ): Response<TemporaryprotectionDTO>

    @POST("/user/town-auth")
    suspend fun posttownauth(
        @Header("x-access-token") token: String,
        @Body locationauthenticationResponse: LocationauthenticationResponse,
    ): Response<TemporaryprotectionDTO>
    //TemporaryprotectionDTO 응답값이 똑같아서 사용


    @GET("/post")
    suspend fun getpost(
        @Header("x-access-token") token: String,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("cat") cat: Boolean?,
        @Query("dog") dog: Boolean?,
        @Query("isComplete") isComplete: Boolean?,
        @Query("weight") weight: List<String>?,
        @Query("type") type:String
    ): Response<PostDTO>

    @GET("/post/temporary-protection/{id}")
    suspend fun gettemporarydetail(
        @Header("x-access-token") token: String,
        @Path ("id") id:Int
    ):Response<TemporarydetailDTO>

    @POST("post/temporary-protection/{id}/photos")
    suspend fun posttemporaryphoto(
        @Header("x-access-token") token: String,
        @Path ("id") id:Int,
        @Part files: List<MultipartBody.Part>?,
    ) : Response<TemporaryprotectionDTO>

    @PATCH("post/temporary-protection/{id}")
    suspend fun patchtemporary(
        @Header("x-access-token") token: String,
        @Path ("id") id:Int,
    ) :Response<TemporaryprotectionDTO>

    @DELETE("post/temporary-protection/{id}")
    suspend fun deletetemporary(
        @Header("x-access-token") token: String,
        @Path ("id") id:Int,
    ): Response<TemporaryprotectionDTO>

    @DELETE("/post/temporary-protection/{id}/photos/{photoId}")
    suspend fun deletetemporaryphoto(
        @Header("x-access-token") token: String,
        @Path ("id") id:Int,
        @Part ("photoId") photoId:Int
    ) : Response<TemporaryprotectionDTO>

    @POST("/post/move-volunteer")
    @Multipart
    @JvmSuppressWildcards
    suspend fun postmoveservicepost(
        @Header("x-access-token") token: String,
        @Part("startAddress") startAddress :RequestBody,
        @Part("endAddress") endAddress: RequestBody,
        @Part("animalTypes") animalTypes: RequestBody,
        @Part("name") name: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("weight") weight: RequestBody,
        @Part("breed") breed: RequestBody,
        @Part("age") age: RequestBody,
        @Part("etc") etc: RequestBody,
        @Part("hopeDate") hopeDate: RequestBody,
        @Part files: List<MultipartBody.Part>?,
    ) : Response<TemporaryprotectionDTO>


    @GET("/post")
    suspend fun getmoveservicepost(
        @Header("x-access-token") token: String,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("cat") cat: Boolean?,
        @Query("dog") dog: Boolean?,
        @Query("isComplete") isComplete: Boolean?,
        @Query("weight") weight: List<String>?,
        @Query("type") type:String
    ): Response<MoveServicePostDTO>

}