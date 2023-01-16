package llama.test.jetpack_dagger_plz.data.model.testdto

data class ArticleTestDTO(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val sourceTestDTO: SourceTestDTO,
    val title: String,
    val url: String,
    val urlToImage: String
)