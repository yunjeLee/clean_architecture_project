package com.example.feature_coin.coin_detail.data

import com.android.domain_coin.model.coin_detail.CoinDetailModel

data class CoinInfo(
    val rank: Int,
    val name: String,
    val symbol: String,
    val isActive: Boolean
)

fun CoinDetailModel.toMapCoinInfo(): CoinInfo =
    CoinInfo(
        rank = rank,
        name = name,
        symbol = symbol,
        isActive = isActive
    )