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
        try {
            binding = ActivityUserDashboardBinding.inflate(layoutInflater)
            setContentView(binding.root)

            prefs = getSharedPreferences("AwakenPrefs", MODE_PRIVATE)

            setupBottomNavigation()
            
            // Load default fragment after view is ready
            if (savedInstanceState == null) {
                binding.root.post {
                    loadFragment(ProductsFragment())
                }
            }
        } catch (e: Exception) {
            android.util.Log.e("UserDashboard", "Error in onCreate: ${e.message}", e)
            finish()
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
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
                else -> false
            }
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
        menuInflater.inflate(R.menu.user_menu, menu)
        return true
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

