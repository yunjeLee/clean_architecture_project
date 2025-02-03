package com.android.feature_coin_detail

data class CoinDetailScreenState(
    val status: CoinDetailScreenStatus = CoinDetailScreenStatus.Loading
) {
    companion object {
        val init = CoinDetailScreenState()
    }
}

sealed interface CoinDetailScreenStatus {
    object Loading: CoinDetailScreenStatus
    object Success: CoinDetailScreenStatus
    object Fail: CoinDetailScreenStatus
}

sealed interface CoinDetailScreenSideEffect {

}

sealed interface CoinDetailScreenAction {
    object OnFetch: CoinDetailScreenAction
}