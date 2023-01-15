package com.example.core.helper

/**
 * This is used for getting states of network call
 */

data class Resource <out T>(val stocksApiStatus: NetworkApiStatus, val data: T?, val message: String?) {

    enum class NetworkApiStatus {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(NetworkApiStatus.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(NetworkApiStatus.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(NetworkApiStatus.LOADING, data, null)
        }
    }
}
