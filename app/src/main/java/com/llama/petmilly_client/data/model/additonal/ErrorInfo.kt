package com.llama.petmilly_client.data.model.additonal

data class ErrorInfo(
    val isAccessTokenExpired: Boolean,
    val isRefreshTokenExpired: Boolean,
    val message: String,
    val statusCode: Int
)