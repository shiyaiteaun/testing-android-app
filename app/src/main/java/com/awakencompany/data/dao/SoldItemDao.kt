package com.awakencompany.data.dao

import androidx.room.*
import com.awakencompany.data.models.SoldItem

@Dao
interface SoldItemDao {
    @Query("SELECT * FROM sold_items ORDER BY saleDate DESC")
    suspend fun getAllSoldItems(): List<SoldItem>

    @Query("SELECT * FROM sold_items WHERE saleId = :saleId LIMIT 1")
    suspend fun getSoldItemById(saleId: Int): SoldItem?

    @Query("SELECT * FROM sold_items WHERE username = :username ORDER BY saleDate DESC")
    suspend fun getSoldItemsByUsername(username: String): List<SoldItem>

    @Query("SELECT * FROM sold_items WHERE saleDate >= :startDate AND saleDate <= :endDate ORDER BY saleDate DESC")
    suspend fun getSoldItemsByDateRange(startDate: Long, endDate: Long): List<SoldItem>

    @Query("SELECT * FROM sold_items WHERE username = :username AND saleDate >= :startDate AND saleDate <= :endDate ORDER BY saleDate DESC")
    suspend fun getSoldItemsByUsernameAndDateRange(username: String, startDate: Long, endDate: Long): List<SoldItem>

    // Daily sales (today)
    @Query("SELECT * FROM sold_items WHERE date(saleDate/1000, 'unixepoch') = date('now') ORDER BY saleDate DESC")
    suspend fun getTodaySoldItems(): List<SoldItem>

    @Query("SELECT * FROM sold_items WHERE username = :username AND date(saleDate/1000, 'unixepoch') = date('now') ORDER BY saleDate DESC")
    suspend fun getTodaySoldItemsByUsername(username: String): List<SoldItem>

    // Sales summary queries - return as separate values
    @Query("SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items")
    suspend fun getTotalSales(): Double

    @Query("SELECT COALESCE(COUNT(*), 0) FROM sold_items")
    suspend fun getTotalTransactions(): Int

    @Query("SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items")
    suspend fun getTotalItemsSold(): Int

    @Query("SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items WHERE saleDate >= :startDate AND saleDate <= :endDate")
    suspend fun getTotalSalesByDateRange(startDate: Long, endDate: Long): Double

    @Query("SELECT COALESCE(COUNT(*), 0) FROM sold_items WHERE saleDate >= :startDate AND saleDate <= :endDate")
    suspend fun getTotalTransactionsByDateRange(startDate: Long, endDate: Long): Int

    @Query("SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items WHERE saleDate >= :startDate AND saleDate <= :endDate")
    suspend fun getTotalItemsSoldByDateRange(startDate: Long, endDate: Long): Int

    @Query("SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items WHERE username = :username AND saleDate >= :startDate AND saleDate <= :endDate")
    suspend fun getTotalSalesByUsernameAndDateRange(username: String, startDate: Long, endDate: Long): Double

    @Query("SELECT COALESCE(COUNT(*), 0) FROM sold_items WHERE username = :username AND saleDate >= :startDate AND saleDate <= :endDate")
    suspend fun getTotalTransactionsByUsernameAndDateRange(username: String, startDate: Long, endDate: Long): Int

    @Query("SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items WHERE username = :username AND saleDate >= :startDate AND saleDate <= :endDate")
    suspend fun getTotalItemsSoldByUsernameAndDateRange(username: String, startDate: Long, endDate: Long): Int

    @Query("SELECT * FROM sold_items WHERE strftime('%Y-%m', datetime(saleDate/1000, 'unixepoch')) = :yearMonth ORDER BY saleDate DESC")
    suspend fun getSoldItemsByMonth(yearMonth: String): List<SoldItem>

    @Query("SELECT * FROM sold_items WHERE strftime('%Y', datetime(saleDate/1000, 'unixepoch')) = :year ORDER BY saleDate DESC")
    suspend fun getSoldItemsByYear(year: String): List<SoldItem>

    @Insert
    suspend fun insertSoldItem(soldItem: SoldItem): Long

    @Update
    suspend fun updateSoldItem(soldItem: SoldItem)

    @Delete
    suspend fun deleteSoldItem(soldItem: SoldItem)
}

