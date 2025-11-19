package com.awakencompany.data.dao

import androidx.room.*
import com.awakencompany.data.models.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM products ORDER BY itemName ASC")
    suspend fun getAllProducts(): List<Product>

    @Query("SELECT * FROM products WHERE itemCode = :itemCode LIMIT 1")
    suspend fun getProductByCode(itemCode: String): Product?

    @Query("SELECT * FROM products WHERE quantity > 0 ORDER BY itemName ASC")
    suspend fun getAvailableProducts(): List<Product>

    @Query("SELECT * FROM products WHERE category = :category ORDER BY itemName ASC")
    suspend fun getProductsByCategory(category: String): List<Product>

    @Query("SELECT * FROM products WHERE itemCode LIKE '%' || :search || '%' OR itemName LIKE '%' || :search || '%' ORDER BY itemName ASC")
    suspend fun searchProducts(search: String): List<Product>

    @Query("SELECT * FROM products WHERE quantity > 0 AND (itemCode LIKE '%' || :search || '%' OR itemName LIKE '%' || :search || '%') ORDER BY itemName ASC")
    suspend fun searchAvailableProducts(search: String): List<Product>

    @Query("SELECT * FROM products WHERE quantity > 0 AND category = :category AND (itemCode LIKE '%' || :search || '%' OR itemName LIKE '%' || :search || '%') ORDER BY itemName ASC")
    suspend fun searchAvailableProductsByCategory(category: String, search: String): List<Product>

    @Query("SELECT DISTINCT category FROM products WHERE category IS NOT NULL ORDER BY category ASC")
    suspend fun getAllCategories(): List<String>

    @Query("SELECT DISTINCT category FROM products WHERE quantity > 0 AND category IS NOT NULL ORDER BY category ASC")
    suspend fun getAvailableCategories(): List<String>

    @Query("SELECT * FROM products WHERE quantity <= :threshold ORDER BY quantity ASC")
    suspend fun getLowStockProducts(threshold: Int = 5): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product): Long

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("UPDATE products SET quantity = quantity - :quantity WHERE itemCode = :itemCode")
    suspend fun decreaseQuantity(itemCode: String, quantity: Int)

    @Query("UPDATE products SET quantity = quantity + :quantity WHERE itemCode = :itemCode")
    suspend fun increaseQuantity(itemCode: String, quantity: Int)
}

