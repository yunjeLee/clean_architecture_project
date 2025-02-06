package com.android.domain_coin.model.coin_list

data class CoinListModel(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)