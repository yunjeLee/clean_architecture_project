package com.android.domain_coin.repository

import com.android.common_util.Result
import com.android.domain_coin.model.coin_detail.CoinDetailModel
import com.android.domain_coin.model.coin_list.CoinListModel
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getCoins(): Result<List<CoinListModel>>
    suspend fun getCoinById(coinId:String): Result<CoinDetailModel>
}