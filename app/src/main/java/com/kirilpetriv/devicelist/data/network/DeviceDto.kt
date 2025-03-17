package com.kirilpetriv.devicelist.data.network

import kotlinx.serialization.Serializable

@Serializable
data class Page<T>(
    val data: List<T>,
)


@Serializable
data class DeviceDto(
    val accessCode: String,
    val name: String,
    val lastScanDate: String
)