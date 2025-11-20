package com.awakencompany.ui.user

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
import com.awakencompany.data.models.Order
import com.awakencompany.data.models.OrderItem
import com.awakencompany.databinding.FragmentOrdersBinding
import com.awakencompany.databinding.ItemOrderBinding
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class OrdersFragment : Fragment() {
    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase
    private lateinit var prefs: SharedPreferences
    private lateinit var adapter: OrdersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        database = AppDatabase.getDatabase(requireContext())
        prefs = requireContext().getSharedPreferences("AwakenPrefs", android.content.Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OrdersAdapter(database) { order ->
            showOrderDetails(order)
        }

        binding.recyclerViewOrders.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewOrders.adapter = adapter

        loadOrders()
    }

    override fun onResume() {
        super.onResume()
        loadOrders()
    }

    private fun loadOrders() {
        lifecycleScope.launch {
            val username = prefs.getString("user_username", null)
            if (username != null) {
                val orders = database.orderDao().getOrdersByUsername(username)
                requireActivity().runOnUiThread {
                    adapter.submitList(orders)
                    if (orders.isEmpty()) {
                        binding.emptyOrdersView.visibility = View.VISIBLE
                        binding.recyclerViewOrders.visibility = View.GONE
                    } else {
                        binding.emptyOrdersView.visibility = View.GONE
                        binding.recyclerViewOrders.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun showOrderDetails(order: Order) {
        lifecycleScope.launch {
            val orderItems = database.orderItemDao().getOrderItemsByOrderId(order.orderId)
            // Get all products for order items
            val products = orderItems.map { item ->
                item.itemCode to database.productDao().getProductByCode(item.itemCode)
            }.toMap()
            
            requireActivity().runOnUiThread {
                val details = buildString {
                    append("Order #${order.orderId}\n")
                    append("Date: ${formatDate(order.orderDate)}\n")
                    append("Customer: ${order.customerName ?: "N/A"}\n")
                    append("Phone: ${order.customerPhone ?: "N/A"}\n")
                    append("Payment: ${order.paymentMethod}\n\n")
                    append("Items:\n")
                    orderItems.forEach { item ->
                        val product = products[item.itemCode]
                        append("• ${product?.itemName ?: item.itemCode} x${item.quantity} = ${formatCurrency(item.total)} Ks\n")
                    }
                    append("\nTotal: ${formatCurrency(order.grandTotal)} Ks")
                }
                
                android.app.AlertDialog.Builder(requireContext())
                    .setTitle("Order Details")
                    .setMessage(details)
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    private fun formatCurrency(amount: Double): String {
        return NumberFormat.getNumberInstance(Locale.US).format(amount.toInt())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class OrdersAdapter(
    private val database: AppDatabase,
    private val onOrderClick: (Order) -> Unit
) : androidx.recyclerview.widget.ListAdapter<Order, OrdersAdapter.OrderViewHolder>(
    OrderDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrderViewHolder(binding, database, onOrderClick)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class OrderViewHolder(
        private val binding: ItemOrderBinding,
        private val database: AppDatabase,
        private val onOrderClick: (Order) -> Unit
    ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.tvOrderId.text = "Order #${order.orderId}"
            binding.tvOrderDate.text = formatDate(order.orderDate)
            binding.tvCustomerName.text = order.customerName ?: "N/A"
            binding.tvGrandTotal.text = "${formatCurrency(order.grandTotal)} Ks"
            binding.tvPaymentMethod.text = order.paymentMethod

            binding.root.setOnClickListener {
                onOrderClick(order)
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

    class OrderDiffCallback : androidx.recyclerview.widget.DiffUtil.ItemCallback<Order>() {
        override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem.orderId == newItem.orderId
        }

        override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
            return oldItem == newItem
        }
    }
}
