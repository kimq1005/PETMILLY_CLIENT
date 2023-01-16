package llama.test.jetpack_dagger_plz.utils

data class ErrorResponse(
    val code: String,
    val message: String,
    val name: String,
    val status: Int
)