package com.example.feature_coin.coin_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_coin.CoinScreenAction
import com.example.feature_coin.CoinViewModel
import com.example.feature_coin.coin_detail.component.CoinDetailErrorScreen
import com.example.feature_coin.coin_detail.component.CoinDetailLoadingScreen
import com.example.feature_coin.coin_detail.component.CoinDetailScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CoinDetailRoute(
    baseViewModel: CoinViewModel = hiltViewModel(),
    coinDetailViewModel: CoinDetailViewModel = hiltViewModel()
) {
    val coinState by baseViewModel.collectAsState()
    val coinDetailState by coinDetailViewModel.collectAsState()

    LaunchedEffect(Unit) {
        coinDetailViewModel.onAction(CoinDetailScreenAction.OnFetch(coinState.coinId))
    }

    coinDetailViewModel.collectSideEffect { sideEffect ->

    }

    when(coinDetailState.status) {
        is CoinDetailScreenStatus.Loading -> {
            CoinDetailLoadingScreen()
        }
        is CoinDetailScreenStatus.Success -> {
            CoinDetailScreen(
                state = coinDetailState,
                onBack = {
                    coinDetailViewModel.onAction(CoinDetailScreenAction.OnReset)
                    baseViewModel.onAction(CoinScreenAction.OnBack)
                }
            )
        }
        is CoinDetailScreenStatus.Fail -> {
            CoinDetailErrorScreen(state = coinDetailState)
        }
    }

}