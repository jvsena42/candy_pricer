package com.bulletapps.candypricer.data.datasource

import com.bulletapps.candypricer.data.api.CandyPricerApi
import com.bulletapps.candypricer.data.parameters.*
import com.bulletapps.candypricer.data.response.*
import javax.inject.Inject

class CandyPricerRemoteDataSource @Inject constructor(private val api: CandyPricerApi) : CandyPricerDataSource {
    override suspend fun createUser(parameters: CreateUserParameters) = api.createUser(parameters)

    override suspend fun login(parameters: LoginParameters): LoginResponse = api.login(parameters)

    override suspend fun createProduct(parameters: CreateProductParameters) = api.createProduct(parameters)

    override suspend fun getProducts(): List<ProductResponse> = api.getProducts()

    override suspend fun createSupply(parameters: CreateSupplyParameters) = api.createSupply(parameters)

    override suspend fun getSupplies(): List<SupplyResponse> = api.getSupplies()

    override suspend fun createUnit(parameters: CreateUnitParameters) = api.createUnit(parameters)

    override suspend fun getUnits(
        key: String,
        value: String,
        disabled: Boolean
    ) = api.getUnits(key, value, disabled)
}