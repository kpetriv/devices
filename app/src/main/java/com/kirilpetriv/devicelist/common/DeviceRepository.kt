package com.kirilpetriv.devicelist.common

import androidx.paging.PagingData
import com.kirilpetriv.devicelist.domain.Device
import kotlinx.coroutines.flow.Flow

interface DeviceRepository {
    fun getPaged(): Flow<PagingData<Device>>
}