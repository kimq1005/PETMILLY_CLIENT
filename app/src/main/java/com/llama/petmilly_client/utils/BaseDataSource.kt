package llama.test.jetpack_dagger_plz.utils

import android.util.Log
import com.google.gson.Gson
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import org.json.JSONObject
import retrofit2.Response

/**
 * Abstract Base Data source class with error handling
 */
abstract class BaseDataSource {
    private val gson = Gson()

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): RemoteResult<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                if (response.code() == 201 || response.code() == 200) {
                    val body = response.body()

                    if (body != null) return RemoteResult.success(body)

                } else {
                    return RemoteResult.check(response.body().toString())
                }
            }

            return try {
                val errorResponse = gson.fromJson(
                    response.errorBody()!!.string(),
                    ErrorResponse::class.java
                )
                val errorMessage = errorResponse.message

                if (errorResponse.code == "auth/id-token-expired") {
                    RemoteResult.refresh(errorMessage, null)
                } else {
                    error(errorMessage)
                }
            } catch (e: java.lang.Exception) {
                error(" ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "BaseDataSource.kt: $e", )
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): RemoteResult<T> {
        return RemoteResult.error(message)
    }
}