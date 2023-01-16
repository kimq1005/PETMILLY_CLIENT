package llama.test.jetpack_dagger_plz.data.model.testdto

data class NewsTestDTO(
    val articleTestDTOS: List<ArticleTestDTO>,
    val status: String,
    val totalResults: Int
)