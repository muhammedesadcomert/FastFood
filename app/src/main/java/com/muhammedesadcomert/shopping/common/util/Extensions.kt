package com.muhammedesadcomert.shopping.common.util

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

inline fun <T, R> Response<T>.safeApiCall(
    transform: (T) -> R, // mapper from data layer to domain layer
): Resource<R, String> =
    try {
        if (this.isSuccessful) {
            Resource.Success(transform(this.body()!!))
        } else {
            Resource.Failure(this.message())
        }
    } catch (e: HttpException) {
        Resource.Failure(e.message ?: "Something went wrong!")
    } catch (e: IOException) {
        Resource.Failure(e.message ?: "Please check your internet connection")
    } catch (e: Exception) {
        Resource.Failure(e.message ?: "Something went wrong!")
    }