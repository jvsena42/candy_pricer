package com.bulletapps.candypricer.data.repository

import com.bulletapps.candypricer.data.parameters.*
import com.bulletapps.candypricer.data.response.*

interface CandyPricerRepository {

    suspend fun createUser(parameters: CreateUserParameters): UserResponse

    suspend fun login(parameters: LoginParameters): LoginResponse

    suspend fun createProduct(parameters: CreateProductParameters): ProductResponse

    suspend fun getProducts(): List<ProductResponse>

    suspend fun createSupply(parameters: CreateSupplyParameters): SupplyResponse

    suspend fun getSupplies(): List<SupplyResponse>

    suspend fun createUnit(parameters: CreateUnitParameters): UnitResponse

    suspend fun getUnits(
        key: String,
        value: String,
        disabled: Boolean,
    ): List<UnitResponse>
}