package com.kirilpetriv.devicelist.common

import androidx.paging.PagingData
import com.kirilpetriv.devicelist.domain.DeviceList
import kotlinx.coroutines.flow.Flow

interface DeviceListRepository {
    fun getPaged(): Flow<PagingData<DeviceList>>
}