package com.llama.petmilly_client.data.repository

import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import com.llama.petmilly_client.data.network.PetMillYApiService
import com.llama.petmilly_client.domain.repository.PetMillyRepo
import llama.test.jetpack_dagger_plz.utils.BaseDataSource
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

class PetMillyRepoImpl @Inject constructor(private val petMillYApiService: PetMillYApiService) :
    PetMillyRepo, BaseDataSource() {

    override suspend fun postkakaotoken(kaKaoResponse: KaKaoResponse): RemoteResult<KaKaoLoginDTO> =
        getResult {
            petMillYApiService.postkakaotoken(kaKaoResponse)
        }
}