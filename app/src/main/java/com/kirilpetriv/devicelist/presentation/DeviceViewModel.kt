package com.kirilpetriv.devicelist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.kirilpetriv.devicelist.common.DeviceRepository

class DeviceViewModel(
    repository: DeviceRepository
) : ViewModel() {
    val devices = repository.getPaged().cachedIn(viewModelScope)
}