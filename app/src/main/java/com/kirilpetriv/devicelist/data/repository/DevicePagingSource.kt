package com.kirilpetriv.devicelist.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kirilpetriv.devicelist.data.network.DeviceService
import com.kirilpetriv.devicelist.data.transformers.toModel
import com.kirilpetriv.devicelist.domain.Device

class DevicePagingSource(
    private val service: DeviceService
) : PagingSource<Int, Device>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Device> {
        val page = params.key ?: 1
        return try {
            val data = service.getDevices(pageNumber = page).data.map { it.toModel() }
            LoadResult.Page(
                data = data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Device>): Int? =
        state.anchorPosition
}