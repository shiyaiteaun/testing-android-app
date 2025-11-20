package com.awakencompany.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.awakencompany.data.models.*
import com.awakencompany.data.dao.*
import java.security.MessageDigest
import java.util.concurrent.Executors

@Database(
    entities = [
        Admin::class,
        User::class,
        Product::class,
        Order::class,
        OrderItem::class,
        IncomingItem::class,
        SoldItem::class,
        FinancialTransaction::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun adminDao(): AdminDao
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
    abstract fun orderDao(): OrderDao
    abstract fun orderItemDao(): OrderItemDao
    abstract fun incomingItemDao(): IncomingItemDao
    abstract fun soldItemDao(): SoldItemDao
    abstract fun financialTransactionDao(): FinancialTransactionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "awaken_company_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                
                // Initialize default admin account in background
                Executors.newSingleThreadExecutor().execute {
                    try {
                        kotlinx.coroutines.runBlocking {
                            initializeDefaultAdmin(instance.adminDao())
                        }
                    } catch (e: Exception) {
                        android.util.Log.e("AppDatabase", "Error initializing admin: ${e.message}", e)
                    }
                }
                
                INSTANCE = instance
                instance
            }
        }

        private suspend fun initializeDefaultAdmin(adminDao: AdminDao) {
            val defaultAdmin = adminDao.getAdminByUsername("shiyai")
            if (defaultAdmin == null) {
                // Default password: Shiyai2025@
                // In production, use proper password hashing (BCrypt)
                val hashedPassword = hashPassword("Shiyai2025@")
                val admin = Admin(
                    username = "shiyai",
                    password = hashedPassword
                )
                adminDao.insertAdmin(admin)
            }
        }

        private fun hashPassword(password: String): String {
            // Simple hash for demo - use BCrypt in production
            val md = MessageDigest.getInstance("SHA-256")
            val hashBytes = md.digest(password.toByteArray())
            return hashBytes.joinToString("") { "%02x".format(it) }
        }
    }
}

