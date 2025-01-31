package com.android.data_coin.entity.coin_detail

import com.google.gson.annotations.SerializedName

data class TagEntity(
    @SerializedName("coin_counter")
    val coinCounter: Int,
    @SerializedName("ico_counter")
    val icoCounter: Int,
    val id: String,
    val name: String
)