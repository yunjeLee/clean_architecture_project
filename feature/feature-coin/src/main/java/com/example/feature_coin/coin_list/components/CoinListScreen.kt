package com.example.feature_coin.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.domain_coin.model.coin_list.CoinListModel
import com.example.feature_coin.coin_list.CoinListItem
import com.example.feature_coin.coin_list.CoinListScreenState

@Composable
fun CoinListScreen(
    state: CoinListScreenState,
    onItemClick: (CoinListModel) -> Unit
) {
    val lazyColumnState = rememberLazyListState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = lazyColumnState,
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.coinList) { item ->
                CoinListItem(
                    coin = item,
                    onItemClick = onItemClick
                )
            }
        }
    }
}

@Composable
fun CoinListLoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun CoinListErrorScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            imageVector = Icons.Default.Build,
            contentDescription = ""
        )
    }
}