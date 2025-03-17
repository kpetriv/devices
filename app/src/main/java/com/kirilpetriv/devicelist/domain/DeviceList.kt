package com.kirilpetriv.devicelist.domain

class DeviceList(
    val accessCode: String,
    val name: String,
    // could be a kotlin.datetime.Instant or similar
    val lastScanDate: String
)