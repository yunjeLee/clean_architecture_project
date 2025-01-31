package com.android.feature_coin_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.feature_coin_list.components.CoinListErrorScreen
import com.android.feature_coin_list.components.CoinListLoadingScreen
import com.android.feature_coin_list.components.CoinListScreen
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CoinListRoute(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state by viewModel.collectAsState()

    when(state.status) {
        CoinListScreenStatus.Loading -> {
            CoinListLoadingScreen()
        }
        CoinListScreenStatus.Success -> {
            CoinListScreen(
                state = state,
                onItemClick = {}
            )
        }
        CoinListScreenStatus.Error -> {
            CoinListErrorScreen(state = state)
        }
    }
}