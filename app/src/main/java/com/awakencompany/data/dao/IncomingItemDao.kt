package com.awakencompany.data.dao

import androidx.room.*
import com.awakencompany.data.models.IncomingItem

@Dao
interface IncomingItemDao {
    @Query("SELECT * FROM incoming_items ORDER BY incomingDate DESC")
    suspend fun getAllIncomingItems(): List<IncomingItem>

    @Query("SELECT * FROM incoming_items WHERE incomingId = :incomingId LIMIT 1")
    suspend fun getIncomingItemById(incomingId: Int): IncomingItem?

    @Query("SELECT * FROM incoming_items WHERE itemCode = :itemCode ORDER BY incomingDate DESC")
    suspend fun getIncomingItemsByItemCode(itemCode: String): List<IncomingItem>

    @Query("SELECT * FROM incoming_items WHERE incomingDate >= :startDate AND incomingDate <= :endDate ORDER BY incomingDate DESC")
    suspend fun getIncomingItemsByDateRange(startDate: Long, endDate: Long): List<IncomingItem>

    @Query("SELECT * FROM incoming_items WHERE supplier LIKE '%' || :supplier || '%' ORDER BY incomingDate DESC")
    suspend fun searchIncomingItemsBySupplier(supplier: String): List<IncomingItem>

    @Query("SELECT * FROM incoming_items WHERE invoiceNo LIKE '%' || :invoiceNo || '%' ORDER BY incomingDate DESC")
    suspend fun searchIncomingItemsByInvoiceNo(invoiceNo: String): List<IncomingItem>

    @Insert
    suspend fun insertIncomingItem(incomingItem: IncomingItem): Long

    @Update
    suspend fun updateIncomingItem(incomingItem: IncomingItem)

    @Delete
    suspend fun deleteIncomingItem(incomingItem: IncomingItem)
}

