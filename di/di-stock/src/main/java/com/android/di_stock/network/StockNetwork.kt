package com.android.di_stock.network

import com.android.data_stock.service.StockApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object StockNetwork {
//    @Provides
//    @Singleton
//    fun provideStockApi(): StockApi =
//        Retrofit.Builder()
//            .baseUrl("www.stock_example.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(StockApi::class.java)
//}