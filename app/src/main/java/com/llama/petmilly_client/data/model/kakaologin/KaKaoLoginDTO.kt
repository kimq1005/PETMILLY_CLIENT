package com.llama.petmilly_client.data.model.kakaologin

data class KaKaoLoginDTO(
    val `data`: Data,
    val isAccessTokenExpired: Boolean,
    val isRefreshTokenExpired: Boolean
):java.io.Serializable