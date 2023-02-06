package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.kakaologin.KaKaoLoginDTO
import com.llama.petmilly_client.data.model.kakaologin.respones.KaKaoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PetMillYApiService {

    @POST("user/kakao-sign-in")
    suspend fun postkakaotoken(
        @Body kaKaoResponse: KaKaoResponse
    ) : Response<KaKaoLoginDTO>
}