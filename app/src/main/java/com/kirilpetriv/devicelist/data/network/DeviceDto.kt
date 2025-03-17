package com.kirilpetriv.devicelist.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Page<T>(
    val data: List<T>,
)

@Serializable
data class DeviceDto(
    @SerialName("accessCode")
    val accessCode: String,
    @SerialName("name")
    val name: String,
    @SerialName("lastScanDate")
    val lastScanDate: String
)