package llama.test.jetpack_dagger_plz.utils

data class RemoteResult<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        CHECK,
        REFRESH
    }

    companion object {
        fun <T> success(data: T): RemoteResult<T> {
            return RemoteResult(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): RemoteResult<T> {
            return RemoteResult(Status.ERROR, data, message)
        }

        fun <T> refresh(message: String, data: T? = null): RemoteResult<T> {
            return RemoteResult(Status.REFRESH, data, message)
        }

        fun <T> check(message: String, data: T? = null): RemoteResult<T> {
            return RemoteResult(Status.CHECK, data, message)
        }
    }
}