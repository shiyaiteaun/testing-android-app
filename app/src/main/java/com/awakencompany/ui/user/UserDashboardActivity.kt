package com.awakencompany.ui.user

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.awakencompany.R
import com.awakencompany.databinding.ActivityUserDashboardBinding
import com.awakencompany.ui.auth.LoginActivity

class UserDashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserDashboardBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        android.util.Log.d("UserDashboard", "onCreate started")
        
        // Step 1: Inflate binding
        try {
            android.util.Log.d("UserDashboard", "Attempting to inflate binding...")
            android.util.Log.d("UserDashboard", "LayoutInflater: ${layoutInflater != null}")
            
            // Check if binding class exists
            try {
                val bindingClass = ActivityUserDashboardBinding::class.java
                android.util.Log.d("UserDashboard", "Binding class found: ${bindingClass.name}")
            } catch (e: ClassNotFoundException) {
                android.util.Log.e("UserDashboard", "CRITICAL: Binding class not found! Need to rebuild project.")
                showErrorAndExit("Binding class not found. Please rebuild the project.")
                return
            }
            
            binding = ActivityUserDashboardBinding.inflate(layoutInflater)
            android.util.Log.d("UserDashboard", "Binding inflated successfully")
            android.util.Log.d("UserDashboard", "Binding root: ${binding.root != null}")
        } catch (e: ClassNotFoundException) {
            android.util.Log.e("UserDashboard", "CRITICAL: Binding class not found: ${e.message}", e)
            e.printStackTrace()
            showErrorAndExit("Binding class not found. Please rebuild the project in Android Studio.")
            return
        } catch (e: android.view.InflateException) {
            android.util.Log.e("UserDashboard", "CRITICAL: Layout inflation error: ${e.message}", e)
            e.printStackTrace()
            // Log the cause if available
            e.cause?.let { cause ->
                android.util.Log.e("UserDashboard", "Cause: ${cause.message}", cause)
            }
            showErrorAndExit("Layout error: ${e.message}. Please check layout files.")
            return
        } catch (e: Exception) {
            android.util.Log.e("UserDashboard", "CRITICAL: Error inflating binding: ${e.message}", e)
            e.printStackTrace()
            e.cause?.let { cause ->
                android.util.Log.e("UserDashboard", "Cause: ${cause.message}", cause)
            }
            showErrorAndExit("Error loading dashboard layout: ${e.message}")
            return
        }
        
        // Step 2: Set content view
        try {
            setContentView(binding.root)
            android.util.Log.d("UserDashboard", "Content view set successfully")
        } catch (e: Exception) {
            android.util.Log.e("UserDashboard", "CRITICAL: Error setting content view: ${e.message}", e)
            e.printStackTrace()
            showErrorAndExit("Error setting up dashboard view")
            return
        }

        // Step 3: Initialize preferences
        try {
            prefs = getSharedPreferences("AwakenPrefs", MODE_PRIVATE)
            android.util.Log.d("UserDashboard", "Preferences initialized")
        } catch (e: Exception) {
            android.util.Log.e("UserDashboard", "Error initializing preferences: ${e.message}", e)
            // Continue - preferences are not critical
        }

        // Step 4: Setup bottom navigation
        try {
            setupBottomNavigation()
            android.util.Log.d("UserDashboard", "Bottom navigation setup completed")
        } catch (e: Exception) {
            android.util.Log.e("UserDashboard", "CRITICAL: Error setting up bottom navigation: ${e.message}", e)
            e.printStackTrace()
            showErrorAndExit("Error setting up navigation")
            return
        }
        
        // Step 5: Load default fragment
        if (savedInstanceState == null) {
            try {
                android.util.Log.d("UserDashboard", "Scheduling fragment load")
                binding.root.post {
                    try {
                        android.util.Log.d("UserDashboard", "Loading default fragment")
                        loadFragment(ProductsFragment())
                        android.util.Log.d("UserDashboard", "Fragment loaded successfully")
                    } catch (e: Exception) {
                        android.util.Log.e("UserDashboard", "Error loading fragment: ${e.message}", e)
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                android.util.Log.e("UserDashboard", "Error scheduling fragment load: ${e.message}", e)
                // Continue - fragment can be loaded later
            }
        }
        
        android.util.Log.d("UserDashboard", "onCreate completed successfully")
    }
    
    private fun showErrorAndExit(message: String) {
        try {
            android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        } catch (e: Exception) {
            android.util.Log.e("UserDashboard", "Error showing error message: ${e.message}", e)
        }
        finish()
    }

    private fun setupBottomNavigation() {
        try {
            android.util.Log.d("UserDashboard", "Setting up bottom navigation")
            val bottomNav = binding.bottomNavigation
            android.util.Log.d("UserDashboard", "Bottom navigation view obtained: ${bottomNav != null}")
            
            bottomNav.setOnItemSelectedListener { item ->
                try {
                    android.util.Log.d("UserDashboard", "Navigation item selected: ${item.itemId}")
                    when (item.itemId) {
                        R.id.nav_products -> {
                            loadFragment(ProductsFragment())
                            true
                        }
                        R.id.nav_cart -> {
                            loadFragment(CartFragment())
                            true
                        }
                        R.id.nav_orders -> {
                            loadFragment(OrdersFragment())
                            true
                        }
                        else -> {
                            android.util.Log.w("UserDashboard", "Unknown navigation item: ${item.itemId}")
                            false
                        }
                    }
                } catch (e: Exception) {
                    android.util.Log.e("UserDashboard", "Error in navigation listener: ${e.message}", e)
                    e.printStackTrace()
                    false
                }
            }
            android.util.Log.d("UserDashboard", "Bottom navigation listener set successfully")
        } catch (e: Exception) {
            android.util.Log.e("UserDashboard", "CRITICAL: Error setting up bottom navigation: ${e.message}", e)
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
            android.util.Log.e("UserDashboard", "Error loading fragment: ${e.message}", e)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return try {
            menuInflater.inflate(R.menu.user_menu, menu)
            android.util.Log.d("UserDashboard", "Options menu created")
            true
        } catch (e: Exception) {
            android.util.Log.e("UserDashboard", "Error creating options menu: ${e.message}", e)
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

    fun updateCartBadge() {
        // Update cart badge in bottom navigation
        val cartItem = binding.bottomNavigation.menu.findItem(R.id.nav_cart)
        val cartCount = com.awakencompany.data.CartManager.getCartItemCount()
        if (cartCount > 0) {
            cartItem?.title = "Cart ($cartCount)"
        } else {
            cartItem?.title = "Cart"
        }
    }

    override fun onResume() {
        super.onResume()
        updateCartBadge()
    }
}

