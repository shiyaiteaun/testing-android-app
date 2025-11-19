package com.awakencompany.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Int = 0,
    val orderDate: Long = System.currentTimeMillis(),
    val username: String? = null,
    val customerName: String? = null,
    val customerAddress: String? = null,
    val customerPhone: String? = null,
    val paymentMethod: String = "cash", // cash or online
    val grandTotal: Double
)

