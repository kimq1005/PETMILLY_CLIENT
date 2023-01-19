package com.llama.petmilly_client.data.repository

import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDTO
import com.llama.petmilly_client.data.network.LibraryApiService
import com.llama.petmilly_client.domain.repository.GetLibraryRepo
import llama.test.jetpack_dagger_plz.utils.BaseDataSource
import llama.test.jetpack_dagger_plz.utils.RemoteResult
import javax.inject.Inject

class GetLibraryRepoImpl @Inject constructor(private val libraryApiService: LibraryApiService) :
    GetLibraryRepo, BaseDataSource() {

    override suspend fun getLibrary(
        KEY: String,
        START_INDEX: Int,
        END_INDEX: Int,
    ): RemoteResult<LibraryDTO> =getResult{
        libraryApiService.getLibrary(KEY, START_INDEX, END_INDEX)
    }
}