package com.kirilpetriv.devicelist.di

import com.kirilpetriv.devicelist.data.network.DeviceService
import org.koin.dsl.module

val deviceListModule = module {
    single { DeviceService.provide() }
}