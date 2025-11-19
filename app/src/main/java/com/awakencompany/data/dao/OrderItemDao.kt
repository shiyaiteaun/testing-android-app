package com.awakencompany.data.dao

import androidx.room.*
import com.awakencompany.data.models.OrderItem

@Dao
interface OrderItemDao {
    @Query("SELECT * FROM order_items WHERE orderId = :orderId")
    suspend fun getOrderItemsByOrderId(orderId: Int): List<OrderItem>

    @Query("SELECT * FROM order_items")
    suspend fun getAllOrderItems(): List<OrderItem>

    @Insert
    suspend fun insertOrderItem(orderItem: OrderItem): Long

    @Insert
    suspend fun insertOrderItems(orderItems: List<OrderItem>)

    @Update
    suspend fun updateOrderItem(orderItem: OrderItem)

    @Delete
    suspend fun deleteOrderItem(orderItem: OrderItem)
}

