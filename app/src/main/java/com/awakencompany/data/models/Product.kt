package com.awakencompany.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey
    val itemCode: String,
    val itemName: String,
    val category: String?,
    val unitPrice: Double,
    var quantity: Int,
    val itemPhoto: String?
)

