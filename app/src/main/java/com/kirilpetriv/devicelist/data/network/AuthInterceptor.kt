package com.kirilpetriv.devicelist.data.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // TODO: Implement the SecuredSharedPreference Token Provider
        val token = "PlRDI6heokZGZznI7AwG55a3rq9h9fmL"

        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        return chain.proceed(request)
    }
}