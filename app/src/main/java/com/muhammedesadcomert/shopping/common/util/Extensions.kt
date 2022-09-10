package com.muhammedesadcomert.shopping.common.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

suspend inline fun <T, R> Response<T>.safeApiCall(
    crossinline transform: (T) -> R, // mapper from data layer to domain layer
): Resource<R, String> {
    val response = this
    return withContext(Dispatchers.IO) {
        try {
            if (response.isSuccessful) {
                Resource.Success(transform(response.body()!!))
            } else {
                Resource.Failure(response.message())
            }
        } catch (e: HttpException) {
            Resource.Failure(e.message ?: "Something went wrong!")
        } catch (e: IOException) {
            Resource.Failure(e.message ?: "Please check your internet connection")
        } catch (e: Exception) {
            Resource.Failure(e.message ?: "Something went wrong!")
        }
    }
}