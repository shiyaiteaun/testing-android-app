package com.awakencompany.ui.admin

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.awakencompany.R
import com.awakencompany.data.AppDatabase
import com.awakencompany.data.models.IncomingItem
import com.awakencompany.data.models.Product
import com.awakencompany.databinding.FragmentIncomingItemsBinding
import com.awakencompany.databinding.ItemIncomingBinding
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class IncomingItemsFragment : Fragment() {
    private var _binding: FragmentIncomingItemsBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase
    private lateinit var adapter: IncomingItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIncomingItemsBinding.inflate(inflater, container, false)
        database = AppDatabase.getDatabase(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = IncomingItemsAdapter(
            database = database,
            onEdit = { item ->
                showEditDialog(item)
            },
            onDelete = { item ->
                showDeleteDialog(item)
            }
        )

        binding.recyclerViewIncomingItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewIncomingItems.adapter = adapter

        binding.btnSearch.setOnClickListener {
            searchIncomingItems()
        }

        loadIncomingItems()
    }

    override fun onResume() {
        super.onResume()
        loadIncomingItems()
    }

    private fun loadIncomingItems() {
        lifecycleScope.launch {
            val items = database.incomingItemDao().getAllIncomingItems()
            requireActivity().runOnUiThread {
                adapter.submitList(items)
                if (items.isEmpty()) {
                    binding.emptyView.visibility = View.VISIBLE
                    binding.recyclerViewIncomingItems.visibility = View.GONE
                } else {
                    binding.emptyView.visibility = View.GONE
                    binding.recyclerViewIncomingItems.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun searchIncomingItems() {
        val searchTerm = binding.etSearch.text.toString().trim()
        lifecycleScope.launch {
            val items = if (searchTerm.isEmpty()) {
                database.incomingItemDao().getAllIncomingItems()
            } else {
                val bySupplier = database.incomingItemDao().searchIncomingItemsBySupplier(searchTerm)
                val byInvoice = database.incomingItemDao().searchIncomingItemsByInvoiceNo(searchTerm)
                (bySupplier + byInvoice).distinctBy { it.incomingId }
            }
            requireActivity().runOnUiThread {
                adapter.submitList(items)
            }
        }
    }

    private fun showEditDialog(@Suppress("UNUSED_PARAMETER") item: IncomingItem) {
        // Edit functionality - can be implemented later
        Toast.makeText(requireContext(), "Edit functionality coming soon", Toast.LENGTH_SHORT).show()
    }

    private fun showDeleteDialog(item: IncomingItem) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Incoming Item")
            .setMessage("Are you sure you want to delete this incoming item?")
            .setPositiveButton("Delete") { _, _ ->
                deleteIncomingItem(item)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun deleteIncomingItem(item: IncomingItem) {
        lifecycleScope.launch {
            try {
                // Get product to update quantity
                val product = database.productDao().getProductByCode(item.itemCode)
                if (product != null && product.quantity >= item.quantityAdded) {
                    // Decrease product quantity
                    database.productDao().decreaseQuantity(item.itemCode, item.quantityAdded)
                }
                
                // Delete incoming item
                database.incomingItemDao().deleteIncomingItem(item)
                
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Incoming item deleted", Toast.LENGTH_SHORT).show()
                    loadIncomingItems()
                }
            } catch (e: Exception) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class IncomingItemsAdapter(
    private val database: AppDatabase,
    private val onEdit: (IncomingItem) -> Unit,
    private val onDelete: (IncomingItem) -> Unit
) : androidx.recyclerview.widget.ListAdapter<IncomingItem, IncomingItemsAdapter.IncomingItemViewHolder>(
    IncomingItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomingItemViewHolder {
        val binding = ItemIncomingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IncomingItemViewHolder(binding, database, onEdit, onDelete)
    }

    override fun onBindViewHolder(holder: IncomingItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class IncomingItemViewHolder(
        private val binding: ItemIncomingBinding,
        private val database: AppDatabase,
        private val onEdit: (IncomingItem) -> Unit,
        private val onDelete: (IncomingItem) -> Unit
    ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bind(item: IncomingItem) {
            // Load product name asynchronously
            kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.IO).launch {
                val product = database.productDao().getProductByCode(item.itemCode)
                binding.root.post {
                    binding.tvItemName.text = product?.itemName ?: item.itemCode
                }
            }

            binding.tvItemCode.text = "Code: ${item.itemCode}"
            binding.tvQuantity.text = "${item.quantityAdded} items"
            binding.tvPurchasePrice.text = "${formatCurrency(item.purchasePrice)} Ks"
            binding.tvTotal.text = "${formatCurrency(item.quantityAdded * item.purchasePrice)} Ks"
            binding.tvDate.text = formatDate(item.incomingDate)
            binding.tvSupplier.text = item.supplier ?: "N/A"
            binding.tvInvoiceNo.text = item.invoiceNo ?: "N/A"
            binding.tvLocation.text = item.location ?: "N/A"
            binding.tvRemarks.text = item.remarks ?: "N/A"

            binding.btnEdit.setOnClickListener {
                onEdit(item)
            }

            binding.btnDelete.setOnClickListener {
                onDelete(item)
            }
        }

        private fun formatDate(timestamp: Long): String {
            val sdf = SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.getDefault())
            return sdf.format(Date(timestamp))
        }

        private fun formatCurrency(amount: Double): String {
            return NumberFormat.getNumberInstance(Locale.US).format(amount.toInt())
        }
    }

    class IncomingItemDiffCallback : androidx.recyclerview.widget.DiffUtil.ItemCallback<IncomingItem>() {
        override fun areItemsTheSame(oldItem: IncomingItem, newItem: IncomingItem): Boolean {
            return oldItem.incomingId == newItem.incomingId
        }

        override fun areContentsTheSame(oldItem: IncomingItem, newItem: IncomingItem): Boolean {
            return oldItem == newItem
        }
    }
}
