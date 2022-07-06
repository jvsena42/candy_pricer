package com.bulletapps.candypricer.data.parameters

import com.google.gson.annotations.SerializedName

data class CreateSupplyParameters(
    @SerializedName("name")
    var name: String,
    @SerializedName("quantity")
    var quantity: Double,
    @SerializedName("value")
    var price: Double,
    @SerializedName("unit_id")
    var unitId: Double,
)
