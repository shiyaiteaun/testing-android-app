package com.awakencompany.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
    val username: String,
    val password: String, // Hashed password
    val fullName: String?,
    val email: String?,
    val phone: String?,
    val status: String = "active", // active or inactive
    val createdBy: Int?,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

