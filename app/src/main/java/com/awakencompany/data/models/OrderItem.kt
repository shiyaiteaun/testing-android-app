package com.awakencompany.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "order_items",
    foreignKeys = [
        ForeignKey(
            entity = Order::class,
            parentColumns = ["orderId"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["itemCode"],
            childColumns = ["itemCode"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OrderItem(
    @PrimaryKey(autoGenerate = true)
    val orderItemId: Int = 0,
    val orderId: Int,
    val itemCode: String,
    val quantity: Int,
    val unitPrice: Double,
    val total: Double
)

