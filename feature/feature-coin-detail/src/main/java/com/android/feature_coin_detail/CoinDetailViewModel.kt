package com.android.feature_coin_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    override val container: Container<CoinDetailScreenState, CoinDetailScreenSideEffect> = container(CoinDetailScreenState.init)

    init {
        onFetch()
    }

    fun onAction(
        action: CoinDetailScreenAction
    ) {
        when(action) {
            is CoinDetailScreenAction.OnFetch -> {
                onFetch()
            }
        }
    }

    private fun onFetch() = intent {
        viewModelScope.launch {
//            val response = getCoinDetailUseCase.invoke()
        }
        reduce {
            state.copy(
                status = CoinDetailScreenStatus.Success
            )
        }
    }
}