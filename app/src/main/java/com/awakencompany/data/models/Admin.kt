package com.awakencompany.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admins")
data class Admin(
    @PrimaryKey(autoGenerate = true)
    val adminId: Int = 0,
    val username: String,
    val password: String, // Hashed password
    val createdAt: Long = System.currentTimeMillis()
)

