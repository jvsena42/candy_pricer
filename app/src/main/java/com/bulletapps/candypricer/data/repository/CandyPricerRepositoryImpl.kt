package com.bulletapps.candypricer.data.repository

import com.bulletapps.candypricer.data.datasource.CandyPricerDataSource
import com.bulletapps.candypricer.data.parameters.*
import com.bulletapps.candypricer.data.response.*
import com.bulletapps.candypricer.domain.model.Result
import com.bulletapps.candypricer.domain.model.Supply
import com.bulletapps.candypricer.presentation.util.safeRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CandyPricerRepositoryImpl @Inject constructor(
    private val dataSource: CandyPricerDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): CandyPricerRepository {
    override suspend fun createUser(parameters: CreateUserParameters) = safeRequest(dispatcher) {
        dataSource.createUser(parameters)
    }

    override suspend fun login(parameters: LoginParameters) = safeRequest(dispatcher) {
        dataSource.login(parameters)
    }

    override suspend fun createProduct(parameters: CreateProductParameters) = safeRequest(dispatcher) {
        dataSource.createProduct(parameters)
    }

    override suspend fun getProducts(): Result<List<ProductResponse>> = safeRequest(dispatcher) {
        dataSource.getProducts()
    }

    override suspend fun createSupply(parameters: CreateSupplyParameters) = safeRequest(dispatcher) {
        dataSource.createSupply(parameters)
    }

    override suspend fun getSupplies(): Result<List<SupplyResponse>> = safeRequest(dispatcher) {
        dataSource.getSupplies()
    }

    override suspend fun createUnit(parameters: CreateUnitParameters) = safeRequest(dispatcher) {
        dataSource.createUnit(parameters)
    }

    override suspend fun getUnits(
        key: String,
        value: String,
        disabled: Boolean
    ) = safeRequest(dispatcher) {
        dataSource.getUnits(key, value, disabled)
    }


}