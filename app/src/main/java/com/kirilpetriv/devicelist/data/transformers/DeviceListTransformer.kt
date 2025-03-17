package com.kirilpetriv.devicelist.data.transformers

import com.kirilpetriv.devicelist.data.network.DeviceDto
import com.kirilpetriv.devicelist.domain.Device

fun DeviceDto.toModel() = Device(
    accessCode = accessCode,
    name = name,
    lastScanDate = lastScanDate
)