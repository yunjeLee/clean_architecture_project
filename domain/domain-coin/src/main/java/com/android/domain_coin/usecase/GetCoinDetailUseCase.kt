package com.android.domain_coin.usecase

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
    suspend operator fun invoke(coinId: String): Result<CoinDetailModel> =
        repository.getCoinById(coinId)
}