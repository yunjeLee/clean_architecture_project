package com.android.di_coin.repository

import com.android.data_coin.repository.CoinRepositoryImpl
import com.android.data_coin.service.CoinApi
import com.android.domain_coin.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinRepository {
    @Provides
    @Singleton
    fun provideCoinRepository(coinApi: CoinApi): CoinRepository =
        CoinRepositoryImpl(coinApi)
}