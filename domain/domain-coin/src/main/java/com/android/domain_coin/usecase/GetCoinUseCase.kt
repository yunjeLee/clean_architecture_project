package com.android.domain_coin.usecase

import com.android.common_util.ApiError
import com.android.common_util.ErrorType
import com.android.common_util.Result
import com.android.common_util.UnknownError
import com.android.common_util.mapErrorMessage
import com.android.domain_coin.model.coin_list.CoinListModel
import com.android.domain_coin.repository.CoinRepository
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
  private val repository: CoinRepository
) {
    suspend operator fun invoke(): List<CoinListModel> {
        return when(val response = repository.getCoins()) {
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