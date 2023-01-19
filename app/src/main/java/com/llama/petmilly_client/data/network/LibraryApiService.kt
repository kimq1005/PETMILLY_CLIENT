package com.llama.petmilly_client.data.network

import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LibraryApiService {

    // http://openapi.seoul.go.kr:8088/(인증키)/xml/SeoulPublicLibraryInfo/1/5/
    @GET("{KEY}/json/SeoulPublicLibraryInfo/{START_INDEX}/{END_INDEX}/")
    suspend fun getLibrary(
        @Path("KEY") KEY:String,
        @Path("START_INDEX") START_INDEX:Int,
        @Path("END_INDEX") END_INDEX:Int,
    ):Response<LibraryDTO>
}