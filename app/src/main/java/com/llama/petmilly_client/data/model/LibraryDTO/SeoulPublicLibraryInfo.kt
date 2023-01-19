package com.llama.petmilly_client.data.model.LibraryDTO

data class SeoulPublicLibraryInfo(
    val RESULT: RESULT,
    val list_total_count: Int,
    val row: List<Row>
)