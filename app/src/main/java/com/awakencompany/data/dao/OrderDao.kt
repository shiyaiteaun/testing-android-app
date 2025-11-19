package com.awakencompany.data.dao

import androidx.room.*
import com.awakencompany.data.models.Order

@Dao
interface OrderDao {
    @Query("SELECT * FROM orders ORDER BY orderDate DESC")
    suspend fun getAllOrders(): List<Order>

    @Query("SELECT * FROM orders WHERE orderId = :orderId LIMIT 1")
    suspend fun getOrderById(orderId: Int): Order?

    @Query("SELECT * FROM orders WHERE username = :username ORDER BY orderDate DESC")
    suspend fun getOrdersByUsername(username: String): List<Order>

    @Query("SELECT * FROM orders WHERE orderDate >= :startDate AND orderDate <= :endDate ORDER BY orderDate DESC")
    suspend fun getOrdersByDateRange(startDate: Long, endDate: Long): List<Order>

    @Query("SELECT * FROM orders WHERE username = :username AND orderDate >= :startDate AND orderDate <= :endDate ORDER BY orderDate DESC")
    suspend fun getOrdersByUsernameAndDateRange(username: String, startDate: Long, endDate: Long): List<Order>

    // Daily orders (today)
    @Query("SELECT * FROM orders WHERE date(orderDate/1000, 'unixepoch') = date('now') ORDER BY orderDate DESC")
    suspend fun getTodayOrders(): List<Order>

    @Query("SELECT * FROM orders WHERE username = :username AND date(orderDate/1000, 'unixepoch') = date('now') ORDER BY orderDate DESC")
    suspend fun getTodayOrdersByUsername(username: String): List<Order>

    // Weekly orders
    @Query("SELECT * FROM orders WHERE orderDate >= :weekStart AND orderDate <= :weekEnd ORDER BY orderDate DESC")
    suspend fun getWeeklyOrders(weekStart: Long, weekEnd: Long): List<Order>

    // Monthly orders
    @Query("SELECT * FROM orders WHERE strftime('%Y-%m', datetime(orderDate/1000, 'unixepoch')) = :yearMonth ORDER BY orderDate DESC")
    suspend fun getMonthlyOrders(yearMonth: String): List<Order>

    // Annual orders
    @Query("SELECT * FROM orders WHERE strftime('%Y', datetime(orderDate/1000, 'unixepoch')) = :year ORDER BY orderDate DESC")
    suspend fun getAnnualOrders(year: String): List<Order>

    @Insert
    suspend fun insertOrder(order: Order): Long

    @Update
    suspend fun updateOrder(order: Order)

    @Delete
    suspend fun deleteOrder(order: Order)
}

