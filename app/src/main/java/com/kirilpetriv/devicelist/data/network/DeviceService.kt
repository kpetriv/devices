package com.kirilpetriv.devicelist.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://hiring.iverify.io/"

interface DeviceService {

    @GET("device")
    suspend fun getDevices(
        @Query("pageNumber") pageNumber: Int,
        @Query("pageSize") pageSize: Int = 60,
    ): Page<DeviceDto>

    companion object {
        fun provide(): DeviceService {
            val jsonConfig = Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
                encodeDefaults = true
            }

            val jsonContentType: MediaType = "application/json".toMediaType()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(AuthInterceptor())
                        .build()
                )
                .addConverterFactory(jsonConfig.asConverterFactory(contentType = jsonContentType))
                .build()

            return retrofit.create(DeviceService::class.java)
        }
    }
}