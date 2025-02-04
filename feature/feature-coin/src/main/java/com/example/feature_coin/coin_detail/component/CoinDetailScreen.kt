package com.example.feature_coin.coin_detail.component

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.domain_coin.model.coin_detail.toMapCoinInfo
import com.example.feature_coin.coin_detail.CoinDetailScreenState
import com.example.feature_coin.coin_list.CoinListItem
import com.example.feature_coin.coin_list.CoinListScreenState

@Composable
fun CoinDetailScreen(
    state: CoinDetailScreenState,
    onBack: () -> Unit
) {
    val scrollState = rememberScrollState()

    state.data?.let { coinData ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(
                    top = 4.dp,
                    start = 12.dp,
                    end = 12.dp,
                )
        ) {
            // 코인 정보
            CoinInfoScreen(data = coinData.toMapCoinInfo())
            Spacer(modifier = Modifier.height(15.dp))
            // 코인 설명
            Text(text = coinData.description,)
            Spacer(modifier = Modifier.height(15.dp))
            // 코인 태그
            CoinTageScreen(tags = coinData.tags)
            Spacer(modifier = Modifier.height(15.dp))
            // 코인 팀
            CoinTeamScreen(members = coinData.team)
        }
    }

    BackHandler(onBack = onBack)
}

@Composable
fun CoinDetailLoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun CoinDetailErrorScreen(
    state: CoinDetailScreenState
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = state.errorText,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.Center)
        )
    }
}