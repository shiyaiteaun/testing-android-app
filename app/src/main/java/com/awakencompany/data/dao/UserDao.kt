package com.awakencompany.data.dao

import androidx.room.*
import com.awakencompany.data.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM users WHERE userId = :userId LIMIT 1")
    suspend fun getUserById(userId: Int): User?

    @Query("SELECT * FROM users WHERE status = 'active'")
    suspend fun getActiveUsers(): List<User>

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE username LIKE '%' || :search || '%' OR fullName LIKE '%' || :search || '%' OR email LIKE '%' || :search || '%'")
    suspend fun searchUsers(search: String): List<User>

    @Query("SELECT * FROM users WHERE status = :status")
    suspend fun getUsersByStatus(status: String): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}

