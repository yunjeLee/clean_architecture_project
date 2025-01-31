package com.android.data_coin.service

import com.android.data_coin.entity.coin_detail.CoinDetailEntity
import com.android.data_coin.entity.coin_list.CoinListEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinListEntity>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailEntity

}