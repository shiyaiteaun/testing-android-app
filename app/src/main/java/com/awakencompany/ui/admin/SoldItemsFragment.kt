package com.awakencompany.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.awakencompany.R
import com.awakencompany.data.AppDatabase
import com.awakencompany.data.models.SoldItem
import com.awakencompany.databinding.FragmentSoldItemsBinding
import com.awakencompany.databinding.ItemSoldBinding
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SoldItemsFragment : Fragment() {
    private var _binding: FragmentSoldItemsBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase
    private lateinit var adapter: SoldItemsAdapter
    private var selectedPeriod = "all" // all, today, week, month, year

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSoldItemsBinding.inflate(inflater, container, false)
        database = AppDatabase.getDatabase(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SoldItemsAdapter()
        binding.recyclerViewSoldItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSoldItems.adapter = adapter

        setupPeriodFilter()
        loadSoldItems()
        loadSummary()
    }

    override fun onResume() {
        super.onResume()
        loadSoldItems()
        loadSummary()
    }

    private fun setupPeriodFilter() {
        val periods = arrayOf("All Time", "Today", "This Week", "This Month", "This Year")
        val periodAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, periods)
        binding.spinnerPeriod.adapter = periodAdapter
        binding.spinnerPeriod.setOnItemSelectedListener(object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedPeriod = when (position) {
                    0 -> "all"
                    1 -> "today"
                    2 -> "week"
                    3 -> "month"
                    4 -> "year"
                    else -> "all"
                }
                loadSoldItems()
                loadSummary()
            }
            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
        })
    }

    private fun loadSoldItems() {
        lifecycleScope.launch {
            val items = when (selectedPeriod) {
                "today" -> {
                    database.soldItemDao().getTodaySoldItems()
                }
                "week" -> {
                    val calendar = Calendar.getInstance()
                    val weekEnd = calendar.timeInMillis
                    calendar.add(Calendar.DAY_OF_WEEK, -7)
                    val weekStart = calendar.timeInMillis
                    database.soldItemDao().getSoldItemsByDateRange(weekStart, weekEnd)
                }
                "month" -> {
                    val calendar = Calendar.getInstance()
                    val yearMonth = SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(Date(calendar.timeInMillis))
                    database.soldItemDao().getSoldItemsByMonth(yearMonth)
                }
                "year" -> {
                    val calendar = Calendar.getInstance()
                    val year = SimpleDateFormat("yyyy", Locale.getDefault()).format(Date(calendar.timeInMillis))
                    database.soldItemDao().getSoldItemsByYear(year)
                }
                else -> {
                    database.soldItemDao().getAllSoldItems()
                }
            }
            requireActivity().runOnUiThread {
                adapter.submitList(items)
                if (items.isEmpty()) {
                    binding.emptyView.visibility = View.VISIBLE
                    binding.recyclerViewSoldItems.visibility = View.GONE
                } else {
                    binding.emptyView.visibility = View.GONE
                    binding.recyclerViewSoldItems.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun loadSummary() {
        lifecycleScope.launch {
            val (totalSales, totalTransactions, totalItems) = when (selectedPeriod) {
                "today" -> {
                    val calendar = Calendar.getInstance()
                    val dayEnd = calendar.timeInMillis
                    calendar.set(Calendar.HOUR_OF_DAY, 0)
                    calendar.set(Calendar.MINUTE, 0)
                    calendar.set(Calendar.SECOND, 0)
                    val dayStart = calendar.timeInMillis
                    Triple(
                        database.soldItemDao().getTotalSalesByDateRange(dayStart, dayEnd),
                        database.soldItemDao().getTotalTransactionsByDateRange(dayStart, dayEnd),
                        database.soldItemDao().getTotalItemsSoldByDateRange(dayStart, dayEnd)
                    )
                }
                "week" -> {
                    val calendar = Calendar.getInstance()
                    val weekEnd = calendar.timeInMillis
                    calendar.add(Calendar.DAY_OF_WEEK, -7)
                    val weekStart = calendar.timeInMillis
                    Triple(
                        database.soldItemDao().getTotalSalesByDateRange(weekStart, weekEnd),
                        database.soldItemDao().getTotalTransactionsByDateRange(weekStart, weekEnd),
                        database.soldItemDao().getTotalItemsSoldByDateRange(weekStart, weekEnd)
                    )
                }
                "month" -> {
                    val calendar = Calendar.getInstance()
                    val yearMonth = SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(Date(calendar.timeInMillis))
                    val monthStart = Calendar.getInstance().apply {
                        set(Calendar.DAY_OF_MONTH, 1)
                        set(Calendar.HOUR_OF_DAY, 0)
                        set(Calendar.MINUTE, 0)
                        set(Calendar.SECOND, 0)
                    }.timeInMillis
                    val monthEnd = Calendar.getInstance().timeInMillis
                    Triple(
                        database.soldItemDao().getTotalSalesByDateRange(monthStart, monthEnd),
                        database.soldItemDao().getTotalTransactionsByDateRange(monthStart, monthEnd),
                        database.soldItemDao().getTotalItemsSoldByDateRange(monthStart, monthEnd)
                    )
                }
                "year" -> {
                    val calendar = Calendar.getInstance()
                    val yearStart = Calendar.getInstance().apply {
                        set(Calendar.MONTH, 0)
                        set(Calendar.DAY_OF_MONTH, 1)
                        set(Calendar.HOUR_OF_DAY, 0)
                        set(Calendar.MINUTE, 0)
                        set(Calendar.SECOND, 0)
                    }.timeInMillis
                    val yearEnd = Calendar.getInstance().timeInMillis
                    Triple(
                        database.soldItemDao().getTotalSalesByDateRange(yearStart, yearEnd),
                        database.soldItemDao().getTotalTransactionsByDateRange(yearStart, yearEnd),
                        database.soldItemDao().getTotalItemsSoldByDateRange(yearStart, yearEnd)
                    )
                }
                else -> {
                    Triple(
                        database.soldItemDao().getTotalSales(),
                        database.soldItemDao().getTotalTransactions(),
                        database.soldItemDao().getTotalItemsSold()
                    )
                }
            }

            requireActivity().runOnUiThread {
                binding.tvTotalSales.text = "${formatCurrency(totalSales)} Ks"
                binding.tvTotalTransactions.text = totalTransactions.toString()
                binding.tvTotalItemsSold.text = totalItems.toString()
            }
        }
    }

    private fun formatCurrency(amount: Double): String {
        return NumberFormat.getNumberInstance(Locale.US).format(amount.toInt())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class SoldItemsAdapter : androidx.recyclerview.widget.ListAdapter<SoldItem, SoldItemsAdapter.SoldItemViewHolder>(
    SoldItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoldItemViewHolder {
        val binding = ItemSoldBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SoldItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SoldItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SoldItemViewHolder(
        private val binding: ItemSoldBinding
    ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SoldItem) {
            binding.tvItemName.text = item.itemName
            binding.tvItemCode.text = "Code: ${item.itemCode}"
            binding.tvQuantity.text = "${item.quantitySold} items"
            binding.tvUnitPrice.text = "${formatCurrency(item.unitPrice)} Ks"
            binding.tvTotalPrice.text = "${formatCurrency(item.totalPrice)} Ks"
            binding.tvDate.text = formatDate(item.saleDate)
            binding.tvUsername.text = item.username ?: "N/A"
        }

        private fun formatDate(timestamp: Long): String {
            val sdf = SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.getDefault())
            return sdf.format(Date(timestamp))
        }

        private fun formatCurrency(amount: Double): String {
            return NumberFormat.getNumberInstance(Locale.US).format(amount.toInt())
        }
    }

    class SoldItemDiffCallback : androidx.recyclerview.widget.DiffUtil.ItemCallback<SoldItem>() {
        override fun areItemsTheSame(oldItem: SoldItem, newItem: SoldItem): Boolean {
            return oldItem.saleId == newItem.saleId
        }

        override fun areContentsTheSame(oldItem: SoldItem, newItem: SoldItem): Boolean {
            return oldItem == newItem
        }
    }
}
