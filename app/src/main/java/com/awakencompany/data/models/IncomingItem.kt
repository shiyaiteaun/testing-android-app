package com.awakencompany.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "incoming_items",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["itemCode"],
            childColumns = ["itemCode"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class IncomingItem(
    @PrimaryKey(autoGenerate = true)
    val incomingId: Int = 0,
    val itemCode: String,
    val quantityAdded: Int,
    val purchasePrice: Double,
    val incomingDate: Long = System.currentTimeMillis(),
    val supplier: String? = null,
    val invoiceNo: String? = null,
    val location: String? = null,
    val remarks: String? = null
)

