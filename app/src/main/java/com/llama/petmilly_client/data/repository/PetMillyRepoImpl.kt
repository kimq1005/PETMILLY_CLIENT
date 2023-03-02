package com.llama.petmilly_client.data.repository

import com.llama.petmilly_client.data.model.TokenResponse
import com.llama.petmilly_client.data.model.accesstoken.AccessTokenDTO
import com.llama.petmilly_client.data.model.additonal.AdditionalSuccessDTO
import com.llama.petmilly_client.data.model.additonal.reponse.AdditionalResponse
import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.model.refreshtoken.RefreshTokenDTO
import com.llama.petmilly_client.data.network.PetMillYApiService
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import llama.test.jetpack_dagger_plz.utils.BaseDataSource
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import retrofit2.Response
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

}