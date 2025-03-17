package com.kirilpetriv.devicelist.data.transformers

import com.kirilpetriv.devicelist.data.network.DeviceDto
import com.kirilpetriv.devicelist.domain.DeviceList

fun DeviceDto.toModel() = DeviceList(
    accessCode = accessCode,
    name = name,
    lastScanDate = lastScanDate
)