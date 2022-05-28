package com.bulletapps.candypricer.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "supply")
data class Supply(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val name: String,
    val price: Double,
    val quantity: Double,
    val unitType: UnitType
)