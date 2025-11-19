package com.awakencompany.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.awakencompany.R
import com.awakencompany.data.AppDatabase
import com.awakencompany.data.models.Product
import com.awakencompany.databinding.FragmentRemainingStockBinding
import com.awakencompany.databinding.ItemStockBinding
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class RemainingStockFragment : Fragment() {
    private var _binding: FragmentRemainingStockBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase
    private lateinit var adapter: StockAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRemainingStockBinding.inflate(inflater, container, false)
        database = AppDatabase.getDatabase(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StockAdapter()
        binding.recyclerViewStock.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewStock.adapter = adapter

        binding.btnSearch.setOnClickListener {
            searchProducts()
        }

        binding.btnLowStock.setOnClickListener {
            showLowStock()
        }

        loadProducts()
    }

    override fun onResume() {
        super.onResume()
        loadProducts()
    }

    private fun loadProducts() {
        lifecycleScope.launch {
            val products = database.productDao().getAllProducts()
            requireActivity().runOnUiThread {
                adapter.submitList(products)
                updateSummary(products)
                if (products.isEmpty()) {
                    binding.emptyView.visibility = View.VISIBLE
                    binding.recyclerViewStock.visibility = View.GONE
                } else {
                    binding.emptyView.visibility = View.GONE
                    binding.recyclerViewStock.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun searchProducts() {
        val searchTerm = binding.etSearch.text.toString().trim()
        lifecycleScope.launch {
            val products = if (searchTerm.isEmpty()) {
                database.productDao().getAllProducts()
            } else {
                database.productDao().searchProducts(searchTerm)
            }
            requireActivity().runOnUiThread {
                adapter.submitList(products)
                updateSummary(products)
            }
        }
    }

    private fun showLowStock() {
        lifecycleScope.launch {
            val products = database.productDao().getLowStockProducts(5)
            requireActivity().runOnUiThread {
                adapter.submitList(products)
                updateSummary(products)
                Toast.makeText(requireContext(), "Showing ${products.size} low stock items", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateSummary(products: List<Product>) {
        val totalItems = products.size
        val totalQuantity = products.sumOf { it.quantity }
        val lowStockCount = products.count { it.quantity <= 5 }
        val outOfStockCount = products.count { it.quantity == 0 }

        binding.tvTotalItems.text = totalItems.toString()
        binding.tvTotalQuantity.text = totalQuantity.toString()
        binding.tvLowStock.text = lowStockCount.toString()
        binding.tvOutOfStock.text = outOfStockCount.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class StockAdapter : androidx.recyclerview.widget.ListAdapter<Product, StockAdapter.StockViewHolder>(
    StockDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val binding = ItemStockBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StockViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class StockViewHolder(
        private val binding: ItemStockBinding
    ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.tvItemName.text = product.itemName
            binding.tvItemCode.text = "Code: ${product.itemCode}"
            binding.tvCategory.text = product.category ?: "Uncategorized"
            binding.tvQuantity.text = product.quantity.toString()
            binding.tvUnitPrice.text = "${formatCurrency(product.unitPrice)} Ks"

            // Set stock status badge
            when {
                product.quantity == 0 -> {
                    binding.tvStockStatus.text = "Out of Stock"
                    binding.tvStockStatus.setBackgroundColor(android.graphics.Color.parseColor("#F44336"))
                    binding.tvStockStatus.setTextColor(android.graphics.Color.WHITE)
                }
                product.quantity <= 5 -> {
                    binding.tvStockStatus.text = "Low Stock"
                    binding.tvStockStatus.setBackgroundColor(android.graphics.Color.parseColor("#FF9800"))
                    binding.tvStockStatus.setTextColor(android.graphics.Color.WHITE)
                }
                else -> {
                    binding.tvStockStatus.text = "In Stock"
                    binding.tvStockStatus.setBackgroundColor(android.graphics.Color.parseColor("#4CAF50"))
                    binding.tvStockStatus.setTextColor(android.graphics.Color.WHITE)
                }
            }
        }

        private fun formatCurrency(amount: Double): String {
            return NumberFormat.getNumberInstance(Locale.US).format(amount.toInt())
        }
    }

    class StockDiffCallback : androidx.recyclerview.widget.DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.itemCode == newItem.itemCode
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}
