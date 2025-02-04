package com.example.feature_coin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_coin.coin_detail.CoinDetailRoute
import com.example.feature_coin.coin_list.CoinListRoute
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CoinRoute(
    viewModel: CoinViewModel = hiltViewModel()
) {

    val state by viewModel.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onAction(CoinScreenAction.OnFetch)
    }

    viewModel.collectSideEffect { sideEffect ->

    }

    when(state.status) {
        is CoinScreenStatus.None -> {}
        is CoinScreenStatus.List -> {
            CoinListRoute()
        }
        is CoinScreenStatus.Detail -> {
            CoinDetailRoute()
        }
    }

}