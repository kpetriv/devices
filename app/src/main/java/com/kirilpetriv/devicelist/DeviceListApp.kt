package com.kirilpetriv.devicelist

import android.app.Application
import com.kirilpetriv.devicelist.di.deviceListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class DeviceListApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DeviceListApp)
            modules(deviceListModule)
        }
    }
}