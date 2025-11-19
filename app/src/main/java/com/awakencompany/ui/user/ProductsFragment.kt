package com.awakencompany.ui.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.awakencompany.R
import com.awakencompany.data.AppDatabase
import com.awakencompany.data.CartManager
import com.awakencompany.data.models.Product
import com.awakencompany.databinding.FragmentProductsBinding
import kotlinx.coroutines.launch

class ProductsFragment : Fragment() {
    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase
    private lateinit var adapter: ProductsAdapter
    private var allCategories = listOf<String>()
    private var selectedCategory: String? = null
    private var searchTerm: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        database = AppDatabase.getDatabase(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductsAdapter(database) { product ->
            addToCart(product)
        }

        binding.recyclerViewProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewProducts.adapter = adapter

        setupSearch()
        loadCategories()
        loadProducts()

        // Auto-refresh every 30 seconds
        view.postDelayed({
            loadProducts()
        }, 30000)
    }

    private fun setupSearch() {
        // Search text watcher
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                searchTerm = s?.toString()?.trim() ?: ""
                filterProducts()
            }
        })

        binding.btnSearch.setOnClickListener {
            searchTerm = binding.etSearch.text.toString().trim()
            filterProducts()
        }
    }

    private fun loadCategories() {
        lifecycleScope.launch {
            allCategories = database.productDao().getAvailableCategories()
            requireActivity().runOnUiThread {
                setupCategoryFilter()
            }
        }
    }

    private fun setupCategoryFilter() {
        val categories = mutableListOf("All Categories")
        categories.addAll(allCategories)
        
        val categoryAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            categories
        )
        
        binding.spinnerCategory.adapter = categoryAdapter
        binding.spinnerCategory.setOnItemSelectedListener(object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedCategory = if (position == 0) null else categories[position]
                filterProducts()
            }
            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
        })
    }

    private fun loadProducts() {
        filterProducts()
    }

    private fun filterProducts() {
        lifecycleScope.launch {
            val products = when {
                !searchTerm.isEmpty() && selectedCategory != null -> {
                    database.productDao().searchAvailableProductsByCategory(selectedCategory!!, searchTerm)
                }
                !searchTerm.isEmpty() -> {
                    database.productDao().searchAvailableProducts(searchTerm)
                }
                selectedCategory != null -> {
                    database.productDao().getProductsByCategory(selectedCategory!!)
                        .filter { it.quantity > 0 }
                }
                else -> {
                    database.productDao().getAvailableProducts()
                }
            }
            requireActivity().runOnUiThread {
                adapter.submitList(products)
            }
        }
    }

    private fun addToCart(product: Product) {
        lifecycleScope.launch {
            // Get current stock from database
            val currentProduct = database.productDao().getProductByCode(product.itemCode)
            if (currentProduct != null && currentProduct.quantity > 0) {
                val existingCartItem = CartManager.getCartItem(product.itemCode)
                val quantityInCart = existingCartItem?.quantity ?: 0
                
                if (quantityInCart + 1 <= currentProduct.quantity) {
                    CartManager.addToCart(currentProduct, 1)
                    requireActivity().runOnUiThread {
                        Toast.makeText(requireContext(), "Added ${product.itemName} to cart", Toast.LENGTH_SHORT).show()
                        updateCartBadge()
                    }
                } else {
                    requireActivity().runOnUiThread {
                        Toast.makeText(
                            requireContext(),
                            "Stock not available. Only ${currentProduct.quantity} items left",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Stock not available", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun updateCartBadge() {
        // Update cart badge in parent activity if exists
        val activity = requireActivity()
        if (activity is UserDashboardActivity) {
            activity.updateCartBadge()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

