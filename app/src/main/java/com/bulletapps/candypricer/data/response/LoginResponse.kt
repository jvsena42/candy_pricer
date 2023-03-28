package com.bulletapps.candypricer.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("user")
    val user: UserResponse,
    @SerializedName("access-token")
    val accessToken: String,
)
