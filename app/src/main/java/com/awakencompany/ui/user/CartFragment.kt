package com.awakencompany.ui.user

import android.app.AlertDialog
import android.content.SharedPreferences
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
import com.awakencompany.data.CartManager
import com.awakencompany.data.models.Order
import com.awakencompany.data.models.OrderItem
import com.awakencompany.data.models.SoldItem
import com.awakencompany.databinding.FragmentCartBinding
import com.awakencompany.databinding.DialogCustomerInfoBinding
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Locale

class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase
    private lateinit var prefs: SharedPreferences
    private lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        database = AppDatabase.getDatabase(requireContext())
        prefs = requireContext().getSharedPreferences("AwakenPrefs", android.content.Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CartAdapter(
            onQuantityUpdate = { itemCode, newQuantity ->
                updateQuantity(itemCode, newQuantity)
            },
            onRemove = { itemCode ->
                removeFromCart(itemCode)
            }
        )

        binding.recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCart.adapter = adapter

        binding.btnCheckout.setOnClickListener {
            if (CartManager.isEmpty()) {
                Toast.makeText(requireContext(), "Cart is empty", Toast.LENGTH_SHORT).show()
            } else {
                showCustomerInfoDialog()
            }
        }

        loadCart()
    }

    override fun onResume() {
        super.onResume()
        loadCart()
    }

    private fun loadCart() {
        val cartItems = CartManager.getCartItems()
        adapter.submitList(cartItems)
        updateTotal()
        
        if (cartItems.isEmpty()) {
            binding.recyclerViewCart.visibility = View.GONE
            binding.emptyCartView.visibility = View.VISIBLE
            binding.btnCheckout.visibility = View.GONE
            binding.tvTotal.visibility = View.GONE
        } else {
            binding.recyclerViewCart.visibility = View.VISIBLE
            binding.emptyCartView.visibility = View.GONE
            binding.btnCheckout.visibility = View.VISIBLE
            binding.tvTotal.visibility = View.VISIBLE
        }
    }

    private fun updateQuantity(itemCode: String, newQuantity: Int) {
        lifecycleScope.launch {
            val product = database.productDao().getProductByCode(itemCode)
            if (product != null) {
                if (newQuantity <= product.quantity) {
                    CartManager.updateQuantity(itemCode, newQuantity)
                    loadCart()
                    updateCartBadge()
                } else {
                    requireActivity().runOnUiThread {
                        Toast.makeText(
                            requireContext(),
                            "Stock not available. Only ${product.quantity} items left",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    // Reset to max available
                    CartManager.updateQuantity(itemCode, product.quantity)
                    loadCart()
                }
            }
        }
    }

    private fun removeFromCart(itemCode: String) {
        CartManager.removeFromCart(itemCode)
        loadCart()
        updateCartBadge()
    }

    private fun updateTotal() {
        val total = CartManager.getCartTotal()
        val formattedTotal = NumberFormat.getNumberInstance(Locale.US).format(total.toInt())
        binding.tvTotal.text = "Grand Total: $formattedTotal Ks"
    }

    private fun updateCartBadge() {
        val activity = requireActivity()
        if (activity is UserDashboardActivity) {
            activity.updateCartBadge()
        }
    }

    private fun showCustomerInfoDialog() {
        val dialogBinding = DialogCustomerInfoBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Customer Information")
            .setView(dialogBinding.root)
            .setPositiveButton("Next") { _, _ ->
                val name = dialogBinding.etCustomerName.text.toString().trim()
                val address = dialogBinding.etCustomerAddress.text.toString().trim()
                val phone = dialogBinding.etCustomerPhone.text.toString().trim()

                if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                    Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                } else {
                    showPaymentDialog(name, address, phone)
                }
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun showPaymentDialog(customerName: String, customerAddress: String, customerPhone: String) {
        var selectedPaymentMethod = "cash"
        val paymentOptions = arrayOf("Cash", "Online Payment")

        AlertDialog.Builder(requireContext())
            .setTitle("Payment Method")
            .setSingleChoiceItems(paymentOptions, 0) { _, which ->
                selectedPaymentMethod = if (which == 0) "cash" else "online"
            }
            .setPositiveButton("Confirm Order") { _, _ ->
                processOrder(customerName, customerAddress, customerPhone, selectedPaymentMethod)
            }
            .setNegativeButton("Back", null)
            .show()
    }

    private fun processOrder(customerName: String, customerAddress: String, customerPhone: String, paymentMethod: String) {
        lifecycleScope.launch {
            try {
                val username = prefs.getString("user_username", null)
                val cartItems = CartManager.getCartItems()

                // Validate stock before processing
                for (cartItem in cartItems) {
                    val product = database.productDao().getProductByCode(cartItem.itemCode)
                    if (product == null || product.quantity < cartItem.quantity) {
                        requireActivity().runOnUiThread {
                            Toast.makeText(
                                requireContext(),
                                "Stock not available for ${cartItem.itemName}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        return@launch
                    }
                }

                // Calculate grand total
                val grandTotal = cartItems.sumOf { it.getTotal() }

                // Create order
                val order = Order(
                    username = username,
                    customerName = customerName,
                    customerAddress = customerAddress,
                    customerPhone = customerPhone,
                    paymentMethod = paymentMethod,
                    grandTotal = grandTotal
                )
                val orderId = database.orderDao().insertOrder(order).toInt()

                // Process each cart item
                for (cartItem in cartItems) {
                    // Create order item
                    val orderItem = OrderItem(
                        orderId = orderId,
                        itemCode = cartItem.itemCode,
                        quantity = cartItem.quantity,
                        unitPrice = cartItem.unitPrice,
                        total = cartItem.getTotal()
                    )
                    database.orderItemDao().insertOrderItem(orderItem)

                    // Update product quantity
                    database.productDao().decreaseQuantity(cartItem.itemCode, cartItem.quantity)

                    // Get product name for sold items
                    val product = database.productDao().getProductByCode(cartItem.itemCode)
                    val productName = product?.itemName ?: cartItem.itemName

                    // Add to sold items
                    val soldItem = SoldItem(
                        itemCode = cartItem.itemCode,
                        itemName = productName,
                        quantitySold = cartItem.quantity,
                        unitPrice = cartItem.unitPrice,
                        totalPrice = cartItem.getTotal(),
                        username = username
                    )
                    database.soldItemDao().insertSoldItem(soldItem)
                }

                // Clear cart
                CartManager.clearCart()

                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Order placed successfully!", Toast.LENGTH_SHORT).show()
                    loadCart()
                    updateCartBadge()
                    
                    // Navigate to orders fragment
                    val activity = requireActivity()
                    if (activity is UserDashboardActivity) {
                        activity.loadFragment(OrdersFragment())
                        activity.binding.bottomNavigation.selectedItemId = R.id.nav_orders
                    }
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

// Cart Adapter
class CartAdapter(
    private val onQuantityUpdate: (String, Int) -> Unit,
    private val onRemove: (String) -> Unit
) : androidx.recyclerview.widget.ListAdapter<CartManager.CartItem, CartAdapter.CartViewHolder>(
    CartDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = com.awakencompany.databinding.ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CartViewHolder(binding, onQuantityUpdate, onRemove)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CartViewHolder(
        private val binding: com.awakencompany.databinding.ItemCartBinding,
        private val onQuantityUpdate: (String, Int) -> Unit,
        private val onRemove: (String) -> Unit
    ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CartManager.CartItem) {
            binding.tvItemName.text = item.itemName
            binding.tvItemCode.text = "Code: ${item.itemCode}"
            binding.tvUnitPrice.text = "${item.unitPrice.toInt()} Ks"
            binding.tvQuantity.text = item.quantity.toString()
            binding.tvTotal.text = "${item.getTotal().toInt()} Ks"

            binding.btnDecrease.setOnClickListener {
                if (item.quantity > 1) {
                    onQuantityUpdate(item.itemCode, item.quantity - 1)
                }
            }

            binding.btnIncrease.setOnClickListener {
                onQuantityUpdate(item.itemCode, item.quantity + 1)
            }

            binding.btnRemove.setOnClickListener {
                onRemove(item.itemCode)
            }
        }
    }

    class CartDiffCallback : androidx.recyclerview.widget.DiffUtil.ItemCallback<CartManager.CartItem>() {
        override fun areItemsTheSame(oldItem: CartManager.CartItem, newItem: CartManager.CartItem): Boolean {
            return oldItem.itemCode == newItem.itemCode
        }

        override fun areContentsTheSame(oldItem: CartManager.CartItem, newItem: CartManager.CartItem): Boolean {
            return oldItem == newItem
        }
    }
}
