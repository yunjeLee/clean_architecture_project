package com.android.domain_coin.usecase

import com.android.common_util.ApiError
import com.android.common_util.ErrorType
import com.android.common_util.Result
import com.android.common_util.UiState
import com.android.common_util.mapErrorMessage
import com.android.domain_coin.model.coin_detail.CoinDetailModel
import com.android.domain_coin.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(coinId: String): CoinDetailModel {
        return when(val response = repository.getCoinById(coinId)) {
            is Result.Success -> {
                response.data
            }
            is Result.Error -> {
                when(response.error) {
                    is ErrorType.Unknown -> throw UnknownError()
                    is ErrorType.Api -> throw ApiError(response.error.mapErrorMessage())
                }
            }
        }
    }
}