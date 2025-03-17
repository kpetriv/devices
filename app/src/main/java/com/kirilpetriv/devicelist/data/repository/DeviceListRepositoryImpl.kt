package com.kirilpetriv.devicelist.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kirilpetriv.devicelist.common.DeviceListRepository
import com.kirilpetriv.devicelist.data.network.DeviceService
import com.kirilpetriv.devicelist.domain.DeviceList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class DeviceListRepositoryImpl(
    private val service: DeviceService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : DeviceListRepository {
    override fun getPaged(): Flow<PagingData<DeviceList>> {
        return Pager(
            config = PagingConfig(
                initialLoadSize = 20,
                pageSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { DeviceListPagingSource(service = service) }
        ).flow.flowOn(dispatcher)
    }
}