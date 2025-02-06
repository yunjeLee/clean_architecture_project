package com.example.feature_coin.coin_list

import com.android.domain_coin.model.coin_list.CoinListModel

data class CoinListScreenState(
    val status: CoinListScreenStatus = CoinListScreenStatus.Loading,
    val coinList: List<CoinListModel> = emptyList(),
    val searchCoinList: List<CoinListModel> = emptyList()
) {
    companion object {
        val init: CoinListScreenState = CoinListScreenState()
    }
}

sealed interface CoinListScreenStatus {
    object Loading: CoinListScreenStatus
    object Success: CoinListScreenStatus
    object Error: CoinListScreenStatus
}

sealed interface CoinListScreenAction {
    object OnFetch: CoinListScreenAction
    object OnReFetch: CoinListScreenAction
}

sealed interface CoinListScreenSideEffect {
    object UnknownError: CoinListScreenSideEffect
    object ApiError: CoinListScreenSideEffect
}

fun List<CoinListModel>.searchCoin(searchText: String): List<CoinListModel> =
    filter { it.name.contains(searchText)  }