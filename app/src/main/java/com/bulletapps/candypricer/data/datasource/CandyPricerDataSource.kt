package com.bulletapps.candypricer.data.datasource

import com.bulletapps.candypricer.data.parameters.*
import com.bulletapps.candypricer.data.response.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CandyPricerDataSource {

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