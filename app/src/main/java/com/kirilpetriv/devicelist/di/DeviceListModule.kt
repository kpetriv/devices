package com.kirilpetriv.devicelist.di

import org.koin.dsl.module

val deviceListModule = module {
    single { DeviceService.provide() }
}