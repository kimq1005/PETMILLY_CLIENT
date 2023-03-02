package com.llama.petmilly_client.data.model.refreshtoken

data class RefreshTokenDTO(
    val data: Data,
    val isAccessTokenExpired: Boolean,
    val isRefreshTokenExpired: Boolean
):java.io.Serializable