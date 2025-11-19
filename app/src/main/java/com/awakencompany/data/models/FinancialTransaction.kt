package com.awakencompany.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "financial_transactions")
data class FinancialTransaction(
    @PrimaryKey(autoGenerate = true)
    val transactionId: Int = 0,
    val transactionDate: Long = System.currentTimeMillis(),
    val description: String,
    val type: String, // income or expense
    val amount: Double,
    val category: String? // e.g., 'sales', 'purchases', 'salary', 'rent'
)

