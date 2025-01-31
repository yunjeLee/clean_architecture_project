package com.android.data_coin.repository

import com.android.common_util.Result
import com.android.common_util.errorLog
import com.android.common_util.mapError
import com.android.common_util.mapErrorMessage
import com.android.data_coin.entity.coin_detail.toCoinDetailModel
import com.android.data_coin.entity.coin_list.toCoinListModel
import com.android.data_coin.service.CoinApi
import com.android.domain_coin.model.coin_detail.CoinDetailModel
import com.android.domain_coin.model.coin_list.CoinListModel
import com.android.domain_coin.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi
): CoinRepository{

    override suspend fun getCoins(): Result<List<CoinListModel>> =
        try {
            Result.Success(coinApi.getCoins().map { it.toCoinListModel() })
        } catch (e: Exception) {
            // 서버에 에러 로그 찍기
            errorLog(e.mapError().mapErrorMessage())
            Result.Error(e.mapError())
        }

    override suspend fun getCoinById(coinId:String): Result<CoinDetailModel> =
        try {
            Result.Success(coinApi.getCoinById(coinId).toCoinDetailModel())
        } catch (e: Exception) {
            // 서버에 에러 로그 찍기
            errorLog(e.mapError().mapErrorMessage())
            Result.Error(e.mapError())
        }
}