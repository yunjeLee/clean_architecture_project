package com.example.feature_coin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(

): ContainerHost<CoinScreenState, CoinScreenSideEffect>, ViewModel() {
    override val container: Container<CoinScreenState, CoinScreenSideEffect> = container(CoinScreenState.init)

    fun onAction(action: CoinScreenAction) {
        when(action) {
            is CoinScreenAction.OnFetch -> {
                onFetch()
            }
            is CoinScreenAction.ShowDetail -> {
                showDetail(action.coinId)
            }
            is CoinScreenAction.OnBack -> {
                onBack()
            }
        }
    }

    private fun onFetch() = intent{
        reduce {
            state.copy(
                status = CoinScreenStatus.List
            )
        }
    }

    private fun showDetail(
        coinId: String
    ) = intent {
        reduce {
            state.copy(
                status = CoinScreenStatus.Detail,
                coinId = coinId
            )
        }
    }

    private fun onBack() = intent {
        reduce {
            state.copy(
                status = CoinScreenStatus.List,
                coinId = ""
            )
        }
    }
}