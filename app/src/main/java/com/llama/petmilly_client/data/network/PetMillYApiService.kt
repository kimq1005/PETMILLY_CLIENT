package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionDTO
import com.llama.petmilly_client.data.model.temporary.TemporaryprotectionResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Part

interface PetMillYApiService {

    @POST("user/kakao-sign-in")
    suspend fun postkakaotoken(
        @Body kaKaoResponse: KaKaoResponse
    ) : Response<KaKaoLoginDTO>

    @POST("user/additional-info")
    suspend fun postadditonalinfo(
        @Header("x-access-token") token: String,
        @Body additionalResponse: AdditionalResponse
    ): Response<AdditionalSuccessDTO>

    @POST("user/reissuance-access-token")
    suspend fun postuseraccesstoken(
        @Body tokenResponse :TokenResponse
    ):Response<AccessTokenDTO>

    @POST("user/reissuance-refresh-token")
    suspend fun postuserrefreshtoken(
        @Body tokenResponse: TokenResponse
    ):Response<RefreshTokenDTO>

    @POST("post/temporary-protection")
    suspend fun posttemporaryprotection(
        @Header("x-access-token") token: String,
        @Body temporaryprotectionResponse: TemporaryprotectionResponse
    ):Response<TemporaryprotectionDTO>


}