package com.example.feature_coin.coin_detail

import com.android.domain_coin.model.coin_detail.CoinDetailModel
import com.android.domain_coin.model.coin_list.CoinListModel

data class CoinDetailScreenState(
    val status: CoinDetailScreenStatus = CoinDetailScreenStatus.Loading,
    val data: CoinDetailModel? = null,
    val errorText: String = ""
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
    data class OnFetch(val coinId: String): CoinDetailScreenAction
    object OnReset: CoinDetailScreenAction
}