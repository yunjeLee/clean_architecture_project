package com.android.domain_coin.usecase

import com.android.common_util.Result
import com.android.common_util.UiState
import com.android.common_util.mapErrorMessage
import com.android.domain_coin.model.coin_list.CoinListModel
import com.android.domain_coin.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
  private val repository: CoinRepository
) {
//    operator fun invoke(): Flow<UiState<List<CoinListModel>>> = flow {
//        emit(UiState.Loading())
//        repository.getCoins().collect { result ->
//            when(result) {
//                is Result.Success -> {
//                    val data = result.data
//                    emit(UiState.Success(data))
//                }
//                is Result.Error -> {
//                    val error = result.error
//                    emit(UiState.Error(error.mapErrorMessage()))
//                }
//            }
//        }
//    }

    suspend operator fun invoke(): Result<List<CoinListModel>> =
        repository.getCoins()
}