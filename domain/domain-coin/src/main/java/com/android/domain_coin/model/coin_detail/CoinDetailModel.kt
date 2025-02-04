package com.android.domain_coin.model.coin_detail

import com.example.common_coin_detail_model.CoinInfo

data class CoinDetailModel(
    val coinId: String,
    val name:String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamModel>
)

fun CoinDetailModel.toMapCoinInfo(): CoinInfo =
    CoinInfo(
        rank = rank,
        name = name,
        symbol = symbol,
        isActive = isActive
    )
