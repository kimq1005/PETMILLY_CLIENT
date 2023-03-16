package com.llama.petmilly_client.data.model.additonal

data class AdditonalTokenFailedDTO(
    val errorInfo: ErrorInfo,
    val path: String,
    val success: Boolean,
    val timestamp: String
):java.io.Serializable