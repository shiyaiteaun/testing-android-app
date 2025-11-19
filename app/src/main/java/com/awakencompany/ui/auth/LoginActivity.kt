package com.awakencompany.ui.auth

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.awakencompany.R
import com.awakencompany.data.AppDatabase
import com.awakencompany.data.models.Admin
import com.awakencompany.data.models.User
import com.awakencompany.databinding.ActivityLoginBinding
import com.awakencompany.ui.admin.AdminDashboardActivity
import com.awakencompany.ui.user.UserDashboardActivity
import kotlinx.coroutines.launch
import java.security.MessageDigest

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var database: AppDatabase
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = AppDatabase.getDatabase(this)
        prefs = getSharedPreferences("AwakenPrefs", MODE_PRIVATE)

        // Check if already logged in
        val isAdminLoggedIn = prefs.getBoolean("admin_logged_in", false)
        val isUserLoggedIn = prefs.getBoolean("user_logged_in", false)

        if (isAdminLoggedIn) {
            navigateToAdmin()
            return
        } else if (isUserLoggedIn) {
            navigateToUser()
            return
        }

        binding.btnAdminLogin.setOnClickListener {
            loginAsAdmin()
        }

        binding.btnUserLogin.setOnClickListener {
            loginAsUser()
        }
    }

    private fun loginAsAdmin() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val admin = database.adminDao().getAdminByUsername(username)
            if (admin != null && verifyPassword(password, admin.password)) {
                // Save login state
                prefs.edit().apply {
                    putBoolean("admin_logged_in", true)
                    putInt("admin_id", admin.adminId)
                    putString("admin_username", admin.username)
                    apply()
                }
                navigateToAdmin()
            } else {
                runOnUiThread {
                    Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun loginAsUser() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val user = database.userDao().getUserByUsername(username)
            if (user != null && user.status == "active" && verifyPassword(password, user.password)) {
                // Save login state
                prefs.edit().apply {
                    putBoolean("user_logged_in", true)
                    putInt("user_id", user.userId)
                    putString("user_username", user.username)
                    apply()
                }
                navigateToUser()
            } else {
                runOnUiThread {
                    Toast.makeText(this@LoginActivity, "Invalid credentials or inactive account", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun verifyPassword(password: String, hashedPassword: String): Boolean {
        val hash = hashPassword(password)
        return hash == hashedPassword
    }

    private fun hashPassword(password: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        val hashBytes = md.digest(password.toByteArray())
        return hashBytes.joinToString("") { "%02x".format(it) }
    }

    private fun navigateToAdmin() {
        val intent = Intent(this, AdminDashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToUser() {
        val intent = Intent(this, UserDashboardActivity::class.java)
        startActivity(intent)
        finish()
    }
}

