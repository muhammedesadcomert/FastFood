package com.muhammedesadcomert.fastfood.common.util

sealed class Resource<out S, out F> {
    data class Success<out S>(val data: S?) : Resource<S, Nothing>()
    data class Failure<out F>(val errorMessage: F) : Resource<Nothing, F>()
}
