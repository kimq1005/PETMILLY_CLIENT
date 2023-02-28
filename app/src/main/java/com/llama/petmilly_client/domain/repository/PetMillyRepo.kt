package com.llama.petmilly_client.domain.repository

import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import llama.test.jetpack_dagger_plz.utils.RemoteResult

interface PetMillyRepo {
    suspend fun postkakaotoken(
        kaKaoResponse: KaKaoResponse,
    ): RemoteResult<KaKaoLoginDTO>
}