package com.android.data_coin.entity.coin_list

import com.android.domain_coin.model.coin_list.CoinListModel
import com.google.gson.annotations.SerializedName

data class CoinListEntity(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinListEntity.toCoinListModel(): CoinListModel =
    CoinListModel(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
