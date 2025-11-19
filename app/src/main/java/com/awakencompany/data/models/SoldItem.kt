package com.awakencompany.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "sold_items",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["itemCode"],
            childColumns = ["itemCode"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SoldItem(
    @PrimaryKey(autoGenerate = true)
    val saleId: Int = 0,
    val itemCode: String,
    val itemName: String,
    val quantitySold: Int,
    val unitPrice: Double,
    val totalPrice: Double,
    val saleDate: Long = System.currentTimeMillis(),
    val username: String? = null
)

