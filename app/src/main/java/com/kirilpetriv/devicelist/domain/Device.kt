package com.kirilpetriv.devicelist.domain

class Device(
    val accessCode: String,
    val name: String,
    // could be a kotlin.datetime.Instant or similar
    val lastScanDate: String
)