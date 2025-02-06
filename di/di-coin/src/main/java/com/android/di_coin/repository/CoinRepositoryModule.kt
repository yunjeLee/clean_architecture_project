package com.android.di_coin.repository

import com.android.data_coin.repository.CoinRepositoryImpl
import com.android.data_coin.service.CoinApi
import com.android.domain_coin.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoinRepositoryModule() {
    @Binds
    @Singleton
    abstract fun provideCoinRepository(impl: CoinRepositoryImpl): CoinRepository
}