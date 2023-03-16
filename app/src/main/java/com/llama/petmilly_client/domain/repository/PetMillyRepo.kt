package com.llama.petmilly_client.domain.repository

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.AdditonalTokenFailedDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

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
        tokenResponse: TokenResponse
    ):RemoteResult<RefreshTokenDTO>
}