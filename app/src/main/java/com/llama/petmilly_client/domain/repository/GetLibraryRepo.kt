package com.llama.petmilly_client.domain.repository

import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDTO
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetLibraryRepo {

    suspend fun getLibrary(
        KEY: String,
        START_INDEX: Int,
        END_INDEX: Int,
    ): RemoteResult<LibraryDTO>
}