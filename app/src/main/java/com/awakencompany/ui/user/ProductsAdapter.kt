package com.awakencompany.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.awakencompany.data.AppDatabase
import com.awakencompany.data.models.Product
import com.awakencompany.databinding.ItemProductBinding

class ProductsAdapter(
    private val database: AppDatabase,
    private val onAddToCart: (Product) -> Unit
) : ListAdapter<Product, ProductsAdapter.ProductViewHolder>(ProductDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding, onAddToCart)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductViewHolder(
        private val binding: ItemProductBinding,
        private val onAddToCart: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.tvItemName.text = product.itemName
            binding.tvItemCode.text = "Code: ${product.itemCode}"
            binding.tvPrice.text = "${product.unitPrice.toInt()} Ks"
            binding.tvStock.text = "Stock: ${product.quantity}"
            binding.tvCategory.text = product.category ?: "Uncategorized"

            binding.btnAddToCart.setOnClickListener {
                onAddToCart(product)
            }
        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.itemCode == newItem.itemCode
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}

