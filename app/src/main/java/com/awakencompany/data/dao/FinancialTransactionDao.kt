package com.awakencompany.data.dao

import androidx.room.*
import com.awakencompany.data.models.FinancialTransaction

@Dao
interface FinancialTransactionDao {
    @Query("SELECT * FROM financial_transactions ORDER BY transactionDate DESC")
    suspend fun getAllTransactions(): List<FinancialTransaction>

    @Query("SELECT * FROM financial_transactions WHERE transactionId = :transactionId LIMIT 1")
    suspend fun getTransactionById(transactionId: Int): FinancialTransaction?

    @Query("SELECT * FROM financial_transactions WHERE type = :type ORDER BY transactionDate DESC")
    suspend fun getTransactionsByType(type: String): List<FinancialTransaction>

    @Query("SELECT * FROM financial_transactions WHERE transactionDate >= :startDate AND transactionDate <= :endDate ORDER BY transactionDate DESC")
    suspend fun getTransactionsByDateRange(startDate: Long, endDate: Long): List<FinancialTransaction>

    @Query("SELECT SUM(amount) FROM financial_transactions WHERE type = 'income' AND transactionDate >= :startDate AND transactionDate <= :endDate")
    suspend fun getTotalIncome(startDate: Long, endDate: Long): Double?

    @Query("SELECT SUM(amount) FROM financial_transactions WHERE type = 'expense' AND transactionDate >= :startDate AND transactionDate <= :endDate")
    suspend fun getTotalExpense(startDate: Long, endDate: Long): Double?

    @Insert
    suspend fun insertTransaction(transaction: FinancialTransaction): Long

    @Update
    suspend fun updateTransaction(transaction: FinancialTransaction)

    @Delete
    suspend fun deleteTransaction(transaction: FinancialTransaction)
}

