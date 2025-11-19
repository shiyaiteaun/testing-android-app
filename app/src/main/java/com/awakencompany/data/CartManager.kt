package com.awakencompany.data

import com.awakencompany.data.models.Product

/**
 * Cart Manager - Manages shopping cart in memory
 * Cart is stored temporarily until checkout
 */
object CartManager {
    data class CartItem(
        val itemCode: String,
        val itemName: String,
        val unitPrice: Double,
        var quantity: Int,
        val itemPhoto: String?,
        val maxQuantity: Int // Current stock available
    ) {
        fun getTotal(): Double = quantity * unitPrice
    }

    private val cartItems = mutableListOf<CartItem>()

    fun addToCart(product: Product, quantity: Int = 1) {
        val existingItem = cartItems.find { it.itemCode == product.itemCode }
        if (existingItem != null) {
            // Update quantity if already in cart
            val newQuantity = existingItem.quantity + quantity
            if (newQuantity <= product.quantity) {
                existingItem.quantity = newQuantity
                existingItem.maxQuantity = product.quantity
            }
        } else {
            // Add new item to cart
            if (quantity <= product.quantity) {
                cartItems.add(
                    CartItem(
                        itemCode = product.itemCode,
                        itemName = product.itemName,
                        unitPrice = product.unitPrice,
                        quantity = quantity,
                        itemPhoto = product.itemPhoto,
                        maxQuantity = product.quantity
                    )
                )
            }
        }
    }

    fun updateQuantity(itemCode: String, newQuantity: Int) {
        val item = cartItems.find { it.itemCode == itemCode }
        if (item != null) {
            if (newQuantity <= 0) {
                removeFromCart(itemCode)
            } else if (newQuantity <= item.maxQuantity) {
                item.quantity = newQuantity
            }
        }
    }

    fun removeFromCart(itemCode: String) {
        cartItems.removeAll { it.itemCode == itemCode }
    }

    fun getCartItems(): List<CartItem> = cartItems.toList()

    fun getCartTotal(): Double = cartItems.sumOf { it.getTotal() }

    fun getCartItemCount(): Int = cartItems.sumOf { it.quantity }

    fun clearCart() {
        cartItems.clear()
    }

    fun getCartItem(itemCode: String): CartItem? = cartItems.find { it.itemCode == itemCode }

    fun isEmpty(): Boolean = cartItems.isEmpty()
}

