package com.kirilpetriv.devicelist.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.kirilpetriv.devicelist.presentation.DeviceViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DeviceScreen(
    modifier: Modifier = Modifier,
    viewModel: DeviceViewModel = koinViewModel(),
) {
    val items = viewModel.devices.collectAsLazyPagingItems()

    Scaffold(modifier = modifier) { innerPadding ->

        when {
            items.loadState.refresh is LoadState.Loading -> Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Loading",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            items.loadState.refresh is LoadState.Error -> Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Error",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            items.itemCount == 0 -> Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Empty list",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    items(count = items.itemCount, key = items.itemKey { it.accessCode }) { index ->
                        items[index]?.also {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(text = "Device Name: ${it.name}")
                                    Text(text = "Access Code: ${it.accessCode}")
                                    Text(text = "Last Scan Timestamp: ${it.lastScanDate}")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}