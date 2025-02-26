package com.example.feature_coin.coin_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_coin.CoinScreenAction
import com.example.feature_coin.CoinViewModel
import com.example.feature_coin.coin_list.components.CoinListErrorScreen
import com.example.feature_coin.coin_list.components.CoinListLoadingScreen
import com.example.feature_coin.coin_list.components.CoinListScreen
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CoinListRoute(
    baseViewModel: CoinViewModel = hiltViewModel(),
    coinListViewModel: CoinListViewModel = hiltViewModel()
) {
    val state by coinListViewModel.collectAsState()

    LaunchedEffect(Unit) {
        coinListViewModel.onAction(CoinListScreenAction.OnFetch)
    }

    coinListViewModel.collectSideEffect { sideEffect ->

    }

    when(state.status) {
        CoinListScreenStatus.Loading -> {
            CoinListLoadingScreen()
        }
        CoinListScreenStatus.Success -> {
            CoinListScreen(
                state = state,
                onItemClick = { coin ->
                    baseViewModel.onAction(CoinScreenAction.ShowDetail(coin.id))
                }
            )
        }
        CoinListScreenStatus.Error -> {
            CoinListErrorScreen(state = state)
        }
    }
}