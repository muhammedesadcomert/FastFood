package com.muhammedesadcomert.shopping.common.base

import com.muhammedesadcomert.shopping.common.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiCall()
                if (response.isSuccessful) {
                    Resource.Success(response.body())
                } else {
                    Resource.Failure(response.message().orEmpty())
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
}
