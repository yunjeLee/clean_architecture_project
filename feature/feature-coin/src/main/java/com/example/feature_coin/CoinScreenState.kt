package com.example.feature_coin

data class CoinScreenState(
    val status: CoinScreenStatus = CoinScreenStatus.None,
    val coinId: String = ""
) {
    companion object {
        val init = CoinScreenState()
    }
}

sealed interface CoinScreenStatus {
    object None: CoinScreenStatus
    object List: CoinScreenStatus
    object Detail: CoinScreenStatus
}

sealed interface  CoinScreenAction {
    object OnFetch: CoinScreenAction
    data class ShowDetail(val coinId: String): CoinScreenAction
    object OnBack: CoinScreenAction
}

sealed interface CoinScreenSideEffect {

}

