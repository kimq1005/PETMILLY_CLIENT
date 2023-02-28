package com.llama.petmilly_client.data.model.kakaologin

import java.io.Serializable

data class Data(
    val isExistAdditionalInfo: Boolean,
    val tokenList: TokenList
): Serializable