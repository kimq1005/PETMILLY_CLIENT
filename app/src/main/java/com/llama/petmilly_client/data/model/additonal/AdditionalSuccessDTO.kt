package com.llama.petmilly_client.data.model.additonal

import com.llama.petmilly_client.data.model.additonal.Data

data class AdditionalSuccessDTO(
    val `data`: Data,
    val isAccessTokenExpired: Boolean,
    val isRefreshTokenExpired: Boolean
):java.io.Serializable