package com.example.feature_coin.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.common_util.ApiError
import com.android.common_util.UnknownError
import com.android.domain_coin.usecase.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase
): ContainerHost<CoinListScreenState, CoinListScreenSideEffect>, ViewModel()  {

    override val container: Container<CoinListScreenState, CoinListScreenSideEffect> = container(
        CoinListScreenState.init
    )

    fun onAction(
        action: CoinListScreenAction
    ) {
        when(action) {
            is CoinListScreenAction.OnFetch -> {
                onFetch()
            }
            else -> {}
        }
    }

    private fun onFetch() = intent {
        viewModelScope.launch {
            try {
                val response = getCoinUseCase.invoke()
                reduce {
                    state.copy(
                        status = CoinListScreenStatus.Success,
                        coinList = response
                    )
                }
            } catch (t: Throwable) {
                reduce { state.copy(status = CoinListScreenStatus.Error) }
                when(t) {
                    is UnknownError -> unknownErrorHandle()
                    is ApiError -> apiErrorHandle()
                }
            }
        }
    }

    private fun unknownErrorHandle() = intent {
        postSideEffect(CoinListScreenSideEffect.UnknownError)
    }

    private fun apiErrorHandle() = intent {
        postSideEffect(CoinListScreenSideEffect.ApiError)
    }
}