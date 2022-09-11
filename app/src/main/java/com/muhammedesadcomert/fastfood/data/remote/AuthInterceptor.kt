package com.muhammedesadcomert.fastfood.data.remote

import com.muhammedesadcomert.fastfood.util.Constant.ALIAS_KEY
import com.muhammedesadcomert.fastfood.util.Constant.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = with(chain.request().newBuilder()) {
            addHeader("Api-Key", API_KEY)
            addHeader("Alias-Key", ALIAS_KEY)
            build()
        }
        return chain.proceed(requestBuilder).newBuilder().build()
    }
}
