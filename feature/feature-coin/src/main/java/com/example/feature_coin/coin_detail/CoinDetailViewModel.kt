package com.example.feature_coin.coin_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.common_util.Result
import com.android.common_util.mapErrorMessage
import com.android.domain_coin.model.coin_detail.CoinDetailModel
import com.android.domain_coin.usecase.GetCoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase
): ContainerHost<CoinDetailScreenState, CoinDetailScreenSideEffect>, ViewModel() {

    override val container: Container<CoinDetailScreenState, CoinDetailScreenSideEffect> = container(
        CoinDetailScreenState.init
    )

    fun onAction(
        action: CoinDetailScreenAction
    ) {
        when(action) {
            is CoinDetailScreenAction.OnFetch -> {
                onFetch(action.coinId)
            }
            is CoinDetailScreenAction.OnReset -> {
                onReset()
            }
        }
    }

    private fun onFetch(
        coinId: String
    ) = intent {
        viewModelScope.launch {
            when(val response = getCoinDetailUseCase.invoke(coinId)) {
                is Result.Success -> {
                    reduce {
                        state.copy(
                            status = CoinDetailScreenStatus.Success,
                            data = response.data
                        )
                    }
                }
                is Result.Error -> {
                    reduce {
                        state.copy(
                            status = CoinDetailScreenStatus.Fail,
                            errorText = response.error.mapErrorMessage()
                        )
                    }
                }
            }
        }
    }

    private fun onReset() = intent {
        reduce {
            state.copy(
                status = CoinDetailScreenStatus.Loading,
                data = null,
                errorText = ""
            )
        }
    }
}