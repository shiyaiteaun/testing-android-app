package com.awakencompany.ui.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.awakencompany.R
import com.awakencompany.data.AppDatabase
import com.awakencompany.databinding.FragmentFinancialStatementBinding
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class FinancialStatementFragment : Fragment() {
    private var _binding: FragmentFinancialStatementBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: AppDatabase
    private var selectedPeriod = "today" // today, week, month, year, all

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinancialStatementBinding.inflate(inflater, container, false)
        database = AppDatabase.getDatabase(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPeriodFilter()
        loadFinancialStatement()
    }

    override fun onResume() {
        super.onResume()
        loadFinancialStatement()
    }

    private fun setupPeriodFilter() {
        val periods = arrayOf("Today", "This Week", "This Month", "This Year", "All Time")
        val periodAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, periods)
        binding.spinnerPeriod.adapter = periodAdapter
        binding.spinnerPeriod.setOnItemSelectedListener(object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedPeriod = when (position) {
                    0 -> "today"
                    1 -> "week"
                    2 -> "month"
                    3 -> "year"
                    4 -> "all"
                    else -> "today"
                }
                loadFinancialStatement()
            }
            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
        })
    }

    private fun loadFinancialStatement() {
        lifecycleScope.launch {
            val (totalSales, totalTransactions, totalItems, avgTransaction) = when (selectedPeriod) {
                "today" -> {
                    val calendar = Calendar.getInstance()
                    val dayEnd = calendar.timeInMillis
                    calendar.set(Calendar.HOUR_OF_DAY, 0)
                    calendar.set(Calendar.MINUTE, 0)
                    calendar.set(Calendar.SECOND, 0)
                    val dayStart = calendar.timeInMillis
                    val sales = database.soldItemDao().getTotalSalesByDateRange(dayStart, dayEnd)
                    val transactions = database.soldItemDao().getTotalTransactionsByDateRange(dayStart, dayEnd)
                    val items = database.soldItemDao().getTotalItemsSoldByDateRange(dayStart, dayEnd)
                    val avg = if (transactions > 0) sales / transactions else 0.0
                    Quadruple(sales, transactions, items, avg)
                }
                "week" -> {
                    val calendar = Calendar.getInstance()
                    val weekEnd = calendar.timeInMillis
                    calendar.add(Calendar.DAY_OF_WEEK, -7)
                    val weekStart = calendar.timeInMillis
                    val sales = database.soldItemDao().getTotalSalesByDateRange(weekStart, weekEnd)
                    val transactions = database.soldItemDao().getTotalTransactionsByDateRange(weekStart, weekEnd)
                    val items = database.soldItemDao().getTotalItemsSoldByDateRange(weekStart, weekEnd)
                    val avg = if (transactions > 0) sales / transactions else 0.0
                    Quadruple(sales, transactions, items, avg)
                }
                "month" -> {
                    val monthStart = Calendar.getInstance().apply {
                        set(Calendar.DAY_OF_MONTH, 1)
                        set(Calendar.HOUR_OF_DAY, 0)
                        set(Calendar.MINUTE, 0)
                        set(Calendar.SECOND, 0)
                    }.timeInMillis
                    val monthEnd = Calendar.getInstance().timeInMillis
                    val sales = database.soldItemDao().getTotalSalesByDateRange(monthStart, monthEnd)
                    val transactions = database.soldItemDao().getTotalTransactionsByDateRange(monthStart, monthEnd)
                    val items = database.soldItemDao().getTotalItemsSoldByDateRange(monthStart, monthEnd)
                    val avg = if (transactions > 0) sales / transactions else 0.0
                    Quadruple(sales, transactions, items, avg)
                }
                "year" -> {
                    val yearStart = Calendar.getInstance().apply {
                        set(Calendar.MONTH, 0)
                        set(Calendar.DAY_OF_MONTH, 1)
                        set(Calendar.HOUR_OF_DAY, 0)
                        set(Calendar.MINUTE, 0)
                        set(Calendar.SECOND, 0)
                    }.timeInMillis
                    val yearEnd = Calendar.getInstance().timeInMillis
                    val sales = database.soldItemDao().getTotalSalesByDateRange(yearStart, yearEnd)
                    val transactions = database.soldItemDao().getTotalTransactionsByDateRange(yearStart, yearEnd)
                    val items = database.soldItemDao().getTotalItemsSoldByDateRange(yearStart, yearEnd)
                    val avg = if (transactions > 0) sales / transactions else 0.0
                    Quadruple(sales, transactions, items, avg)
                }
                else -> {
                    val sales = database.soldItemDao().getTotalSales()
                    val transactions = database.soldItemDao().getTotalTransactions()
                    val items = database.soldItemDao().getTotalItemsSold()
                    val avg = if (transactions > 0) sales / transactions else 0.0
                    Quadruple(sales, transactions, items, avg)
                }
            }

            requireActivity().runOnUiThread {
                binding.tvTotalRevenue.text = "${formatCurrency(totalSales)} Ks"
                binding.tvTotalTransactions.text = totalTransactions.toString()
                binding.tvTotalItemsSold.text = totalItems.toString()
                binding.tvAverageTransaction.text = "${formatCurrency(avgTransaction)} Ks"
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

    private data class Quadruple(val first: Double, val second: Int, val third: Int, val fourth: Double)
}
