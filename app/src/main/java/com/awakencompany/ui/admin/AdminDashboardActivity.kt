package com.awakencompany.ui.admin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.awakencompany.R
import com.awakencompany.databinding.ActivityAdminDashboardBinding
import com.awakencompany.ui.auth.LoginActivity

class AdminDashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminDashboardBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        android.util.Log.d("AdminDashboard", "onCreate started")
        
        // Step 1: Inflate binding
        try {
            android.util.Log.d("AdminDashboard", "Attempting to inflate binding...")
            android.util.Log.d("AdminDashboard", "LayoutInflater: ${layoutInflater != null}")
            
            // Check if binding class exists
            try {
                val bindingClass = ActivityAdminDashboardBinding::class.java
                android.util.Log.d("AdminDashboard", "Binding class found: ${bindingClass.name}")
            } catch (e: ClassNotFoundException) {
                android.util.Log.e("AdminDashboard", "CRITICAL: Binding class not found! Need to rebuild project.")
                showErrorAndExit("Binding class not found. Please rebuild the project.")
                return
            }
            
            binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
            android.util.Log.d("AdminDashboard", "Binding inflated successfully")
            android.util.Log.d("AdminDashboard", "Binding root: ${binding.root != null}")
        } catch (e: ClassNotFoundException) {
            android.util.Log.e("AdminDashboard", "CRITICAL: Binding class not found: ${e.message}", e)
            e.printStackTrace()
            showErrorAndExit("Binding class not found. Please rebuild the project in Android Studio.")
            return
        } catch (e: android.view.InflateException) {
            android.util.Log.e("AdminDashboard", "CRITICAL: Layout inflation error: ${e.message}", e)
            e.printStackTrace()
            // Log the cause if available
            e.cause?.let { cause ->
                android.util.Log.e("AdminDashboard", "Cause: ${cause.message}", cause)
            }
            showErrorAndExit("Layout error: ${e.message}. Please check layout files.")
            return
        } catch (e: Exception) {
            android.util.Log.e("AdminDashboard", "CRITICAL: Error inflating binding: ${e.message}", e)
            e.printStackTrace()
            e.cause?.let { cause ->
                android.util.Log.e("AdminDashboard", "Cause: ${cause.message}", cause)
            }
            showErrorAndExit("Error loading dashboard layout: ${e.message}")
            return
        }
        
        // Step 2: Set content view
        try {
            setContentView(binding.root)
            android.util.Log.d("AdminDashboard", "Content view set successfully")
        } catch (e: Exception) {
            android.util.Log.e("AdminDashboard", "CRITICAL: Error setting content view: ${e.message}", e)
            e.printStackTrace()
            showErrorAndExit("Error setting up dashboard view")
            return
        }

        // Step 3: Initialize preferences
        try {
            prefs = getSharedPreferences("AwakenPrefs", MODE_PRIVATE)
            android.util.Log.d("AdminDashboard", "Preferences initialized")
        } catch (e: Exception) {
            android.util.Log.e("AdminDashboard", "Error initializing preferences: ${e.message}", e)
            // Continue - preferences are not critical
        }

        // Step 4: Setup bottom navigation
        try {
            setupBottomNavigation()
            android.util.Log.d("AdminDashboard", "Bottom navigation setup completed")
        } catch (e: Exception) {
            android.util.Log.e("AdminDashboard", "CRITICAL: Error setting up bottom navigation: ${e.message}", e)
            e.printStackTrace()
            showErrorAndExit("Error setting up navigation")
            return
        }
        
        // Step 5: Load default fragment
        if (savedInstanceState == null) {
            try {
                android.util.Log.d("AdminDashboard", "Scheduling fragment load")
                binding.root.post {
                    try {
                        android.util.Log.d("AdminDashboard", "Loading default fragment")
                        loadFragment(AddItemFragment())
                        android.util.Log.d("AdminDashboard", "Fragment loaded successfully")
                    } catch (e: Exception) {
                        android.util.Log.e("AdminDashboard", "Error loading fragment: ${e.message}", e)
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                android.util.Log.e("AdminDashboard", "Error scheduling fragment load: ${e.message}", e)
                // Continue - fragment can be loaded later
            }
        }
        
        android.util.Log.d("AdminDashboard", "onCreate completed successfully")
    }
    
    private fun showErrorAndExit(message: String) {
        try {
            android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        } catch (e: Exception) {
            android.util.Log.e("AdminDashboard", "Error showing error message: ${e.message}", e)
        }
        finish()
    }

    private fun setupBottomNavigation() {
        try {
            android.util.Log.d("AdminDashboard", "Setting up bottom navigation")
            val bottomNav = binding.bottomNavigation
            android.util.Log.d("AdminDashboard", "Bottom navigation view obtained: ${bottomNav != null}")
            
            bottomNav.setOnItemSelectedListener { item ->
                try {
                    android.util.Log.d("AdminDashboard", "Navigation item selected: ${item.itemId}")
                    when (item.itemId) {
                        R.id.nav_add_item -> {
                            loadFragment(AddItemFragment())
                            true
                        }
                        R.id.nav_incoming -> {
                            loadFragment(IncomingItemsFragment())
                            true
                        }
                        R.id.nav_sold -> {
                            loadFragment(SoldItemsFragment())
                            true
                        }
                        R.id.nav_stock -> {
                            loadFragment(RemainingStockFragment())
                            true
                        }
                        R.id.nav_financial -> {
                            loadFragment(FinancialStatementFragment())
                            true
                        }
                        R.id.nav_users -> {
                            loadFragment(UserManagementFragment())
                            true
                        }
                        else -> {
                            android.util.Log.w("AdminDashboard", "Unknown navigation item: ${item.itemId}")
                            false
                        }
                    }
                } catch (e: Exception) {
                    android.util.Log.e("AdminDashboard", "Error in navigation listener: ${e.message}", e)
                    e.printStackTrace()
                    false
                }
            }
            android.util.Log.d("AdminDashboard", "Bottom navigation listener set successfully")
        } catch (e: Exception) {
            android.util.Log.e("AdminDashboard", "CRITICAL: Error setting up bottom navigation: ${e.message}", e)
            e.printStackTrace()
            throw e // Re-throw to be caught by onCreate
        }
    }

    fun loadFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commitAllowingStateLoss()
        } catch (e: Exception) {
            android.util.Log.e("AdminDashboard", "Error loading fragment: ${e.message}", e)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return try {
            menuInflater.inflate(R.menu.admin_menu, menu)
            android.util.Log.d("AdminDashboard", "Options menu created")
            true
        } catch (e: Exception) {
            android.util.Log.e("AdminDashboard", "Error creating options menu: ${e.message}", e)
            false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_logout -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        prefs.edit().clear().apply()
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}

