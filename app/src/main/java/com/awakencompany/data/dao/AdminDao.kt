package com.awakencompany.data.dao

import androidx.room.*
import com.awakencompany.data.models.Admin

@Dao
interface AdminDao {
    @Query("SELECT * FROM admins WHERE username = :username LIMIT 1")
    suspend fun getAdminByUsername(username: String): Admin?

    @Query("SELECT * FROM admins WHERE adminId = :adminId LIMIT 1")
    suspend fun getAdminById(adminId: Int): Admin?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdmin(admin: Admin): Long

    @Update
    suspend fun updateAdmin(admin: Admin)

    @Delete
    suspend fun deleteAdmin(admin: Admin)

    @Query("SELECT * FROM admins")
    suspend fun getAllAdmins(): List<Admin>
}

