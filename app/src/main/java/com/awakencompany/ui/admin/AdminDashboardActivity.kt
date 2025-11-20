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
        binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getSharedPreferences("AwakenPrefs", MODE_PRIVATE)

        setupBottomNavigation()
        
        // Load default fragment after view is ready
        if (savedInstanceState == null) {
            binding.root.post {
                loadFragment(AddItemFragment())
            }
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
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
            android.util.Log.e("AdminDashboard", "Error loading fragment: ${e.message}", e)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.admin_menu, menu)
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
}

