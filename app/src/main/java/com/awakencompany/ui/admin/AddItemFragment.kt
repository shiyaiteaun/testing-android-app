package com.awakencompany.ui.admin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.awakencompany.R
import com.awakencompany.data.AppDatabase
import com.awakencompany.data.models.IncomingItem
import com.awakencompany.data.models.Product
import com.awakencompany.databinding.FragmentAddItemBinding
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class AddItemFragment : Fragment() {
    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try {
            android.util.Log.d("AddItemFragment", "onCreateView started")
            _binding = FragmentAddItemBinding.inflate(inflater, container, false)
            android.util.Log.d("AddItemFragment", "Binding inflated")
            
            // Initialize database safely
            try {
                database = AppDatabase.getDatabase(requireContext())
                android.util.Log.d("AddItemFragment", "Database initialized")
            } catch (dbError: Exception) {
                android.util.Log.e("AddItemFragment", "Database initialization error: ${dbError.message}", dbError)
                // Continue anyway - database might be initialized later
            }
            
            android.util.Log.d("AddItemFragment", "onCreateView completed successfully")
            return binding.root
        } catch (e: Exception) {
            android.util.Log.e("AddItemFragment", "Error in onCreateView: ${e.message}", e)
            e.printStackTrace()
            // Return a simple error view if binding fails
            val errorView = android.widget.TextView(requireContext())
            errorView.text = "Error loading form. Please restart the app."
            errorView.setPadding(32, 32, 32, 32)
            errorView.textSize = 16f
            return errorView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTotalCalculation()
        binding.btnSave.setOnClickListener {
            saveProduct()
        }
    }

    private fun setupTotalCalculation() {
        val priceWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                calculateTotal()
            }
        }

        binding.etQuantity.addTextChangedListener(priceWatcher)
        binding.etPurchasePrice.addTextChangedListener(priceWatcher)
    }

    private fun calculateTotal() {
        val quantity = binding.etQuantity.text.toString().trim().toIntOrNull() ?: 0
        val purchasePrice = binding.etPurchasePrice.text.toString().trim().toDoubleOrNull() ?: 0.0
        val total = quantity * purchasePrice
        val formattedTotal = NumberFormat.getNumberInstance(Locale.US).format(total.toInt())
        binding.tvTotal.text = "Total: $formattedTotal Ks"
    }

    private fun saveProduct() {
        val itemCode = binding.etItemCode.text.toString().trim()
        val itemName = binding.etItemName.text.toString().trim()
        val category = binding.etCategory.text.toString().trim()
        val unitPrice = binding.etUnitPrice.text.toString().trim()
        val quantity = binding.etQuantity.text.toString().trim()
        val supplier = binding.etSupplier.text.toString().trim()
        val invoiceNo = binding.etInvoiceNo.text.toString().trim()
        val purchasePrice = binding.etPurchasePrice.text.toString().trim()
        val location = binding.etLocation.text.toString().trim()
        val remarks = binding.etRemarks.text.toString().trim()

        if (itemCode.isEmpty() || itemName.isEmpty() || unitPrice.isEmpty() || quantity.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all required fields", Toast.LENGTH_SHORT).show()
            return
        }

        val price = unitPrice.toDoubleOrNull()
        val qty = quantity.toIntOrNull()
        val purchasePriceValue = purchasePrice.toDoubleOrNull() ?: 0.0

        if (price == null || qty == null) {
            Toast.makeText(requireContext(), "Invalid price or quantity", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            try {
                // Check if product exists
                val existingProduct = database.productDao().getProductByCode(itemCode)
                
                val product = if (existingProduct != null) {
                    // Update existing product - add to quantity
                    existingProduct.copy(
                        itemName = itemName,
                        category = if (category.isEmpty()) null else category,
                        unitPrice = price,
                        quantity = existingProduct.quantity + qty
                    )
                } else {
                    // Create new product
                    Product(
                        itemCode = itemCode,
                        itemName = itemName,
                        category = if (category.isEmpty()) null else category,
                        unitPrice = price,
                        quantity = qty,
                        itemPhoto = null
                    )
                }

                // Insert or update product
                database.productDao().insertProduct(product)

                // Add to incoming items
                val incomingItem = IncomingItem(
                    itemCode = itemCode,
                    quantityAdded = qty,
                    purchasePrice = purchasePriceValue,
                    supplier = if (supplier.isEmpty()) null else supplier,
                    invoiceNo = if (invoiceNo.isEmpty()) null else invoiceNo,
                    location = if (location.isEmpty()) null else location,
                    remarks = if (remarks.isEmpty()) null else remarks
                )
                database.incomingItemDao().insertIncomingItem(incomingItem)

                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Product added successfully", Toast.LENGTH_SHORT).show()
                    clearFields()
                }
            } catch (e: Exception) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun clearFields() {
        binding.etItemCode.text?.clear()
        binding.etItemName.text?.clear()
        binding.etCategory.text?.clear()
        binding.etUnitPrice.text?.clear()
        binding.etQuantity.text?.clear()
        binding.etSupplier.text?.clear()
        binding.etInvoiceNo.text?.clear()
        binding.etPurchasePrice.text?.clear()
        binding.etLocation.text?.clear()
        binding.etRemarks.text?.clear()
        binding.tvTotal.text = "Total: 0 Ks"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

