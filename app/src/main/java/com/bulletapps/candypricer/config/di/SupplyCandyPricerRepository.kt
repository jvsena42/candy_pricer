package com.bulletapps.candypricer.config.di

import com.bulletapps.candypricer.data.datasource.CandyPricerDataSource
import com.bulletapps.candypricer.data.repository.CandyPricerRepository
import com.bulletapps.candypricer.data.repository.CandyPricerRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SupplyCandyPricerRepository {

    @Singleton
    @Provides
    fun providesCandyPricerRepository (dataSource: CandyPricerDataSource): CandyPricerRepository {
        return CandyPricerRepositoryImpl(dataSource)
    }
}