package com.kirilpetriv.devicelist.di

import com.kirilpetriv.devicelist.common.DeviceRepository
import com.kirilpetriv.devicelist.data.network.DeviceService
import com.kirilpetriv.devicelist.data.repository.DeviceRepositoryImpl
import com.kirilpetriv.devicelist.presentation.DeviceViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val deviceListAppModule = module {
    single { DeviceService.provide() }
    single<DeviceRepository> { DeviceRepositoryImpl(get()) }

    viewModel { DeviceViewModel(repository = get()) }
}