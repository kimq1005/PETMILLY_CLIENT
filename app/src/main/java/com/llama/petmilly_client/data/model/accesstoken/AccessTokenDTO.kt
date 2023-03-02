package com.llama.petmilly_client.data.model.accesstoken

data class AccessTokenDTO(
    val `data`: Data,
    val isAccessTokenExpired: Boolean,
    val isRefreshTokenExpired: Boolean
)