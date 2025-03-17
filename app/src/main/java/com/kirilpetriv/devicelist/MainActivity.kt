package com.kirilpetriv.devicelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.kirilpetriv.devicelist.presentation.composables.DeviceScreen
import com.kirilpetriv.devicelist.ui.theme.DeviceListTheme
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeviceListTheme {
                KoinContext {
                    DeviceScreen(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}