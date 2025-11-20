package com.awakencompany.ui.auth

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.awakencompany.R
import com.awakencompany.data.AppDatabase

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_splash)
            
            // Initialize database in background
            Thread {
                try {
                    AppDatabase.getDatabase(this)
                } catch (e: Exception) {
                    android.util.Log.e("SplashActivity", "Error initializing database: ${e.message}", e)
                }
            }.start()
            
            // Navigate to login after 2 seconds
            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    android.util.Log.e("SplashActivity", "Error navigating to login: ${e.message}", e)
                }
            }, 2000)
        } catch (e: Exception) {
            android.util.Log.e("SplashActivity", "Error in onCreate: ${e.message}", e)
            finish()
        }
    }
}

