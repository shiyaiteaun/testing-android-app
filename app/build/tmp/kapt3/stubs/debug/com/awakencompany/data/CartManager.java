package com.awakencompany.data;

import java.lang.System;

/**
 * Cart Manager - Manages shopping cart in memory
 * Cart is stored temporarily until checkout
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/awakencompany/data/CartManager;", "", "()V", "cartItems", "", "Lcom/awakencompany/data/CartManager$CartItem;", "addToCart", "", "product", "Lcom/awakencompany/data/models/Product;", "quantity", "", "clearCart", "getCartItem", "itemCode", "", "getCartItemCount", "getCartItems", "", "getCartTotal", "", "isEmpty", "", "removeFromCart", "updateQuantity", "newQuantity", "CartItem", "app_debug"})
public final class CartManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.awakencompany.data.CartManager INSTANCE = null;
    private static final java.util.List<com.awakencompany.data.CartManager.CartItem> cartItems = null;
    
    private CartManager() {
        super();
    }
    
    public final void addToCart(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.Product product, int quantity) {
    }
    
    public final void updateQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, int newQuantity) {
    }
    
    public final void removeFromCart(@org.jetbrains.annotations.NotNull()
    java.lang.String itemCode) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.awakencompany.data.CartManager.CartItem> getCartItems() {
        return null;
    }
    
    public final double getCartTotal() {
        return 0.0;
    }
    
    public final int getCartItemCount() {
        return 0;
    }
    
    public final void clearCart() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.awakencompany.data.CartManager.CartItem getCartItem(@org.jetbrains.annotations.NotNull()
    java.lang.String itemCode) {
        return null;
    }
    
    public final boolean isEmpty() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00c6\u0003JG\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\"\u001a\u00020\u0006J\t\u0010#\u001a\u00020\bH\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/awakencompany/data/CartManager$CartItem;", "", "itemCode", "", "itemName", "unitPrice", "", "quantity", "", "itemPhoto", "maxQuantity", "(Ljava/lang/String;Ljava/lang/String;DILjava/lang/String;I)V", "getItemCode", "()Ljava/lang/String;", "getItemName", "getItemPhoto", "getMaxQuantity", "()I", "setMaxQuantity", "(I)V", "getQuantity", "setQuantity", "getUnitPrice", "()D", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "getTotal", "hashCode", "toString", "app_debug"})
    public static final class CartItem {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String itemCode = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String itemName = null;
        private final double unitPrice = 0.0;
        private int quantity;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String itemPhoto = null;
        private int maxQuantity;
        
        @org.jetbrains.annotations.NotNull()
        public final com.awakencompany.data.CartManager.CartItem copy(@org.jetbrains.annotations.NotNull()
        java.lang.String itemCode, @org.jetbrains.annotations.NotNull()
        java.lang.String itemName, double unitPrice, int quantity, @org.jetbrains.annotations.Nullable()
        java.lang.String itemPhoto, int maxQuantity) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public CartItem(@org.jetbrains.annotations.NotNull()
        java.lang.String itemCode, @org.jetbrains.annotations.NotNull()
        java.lang.String itemName, double unitPrice, int quantity, @org.jetbrains.annotations.Nullable()
        java.lang.String itemPhoto, int maxQuantity) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getItemCode() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getItemName() {
            return null;
        }
        
        public final double component3() {
            return 0.0;
        }
        
        public final double getUnitPrice() {
            return 0.0;
        }
        
        public final int component4() {
            return 0;
        }
        
        public final int getQuantity() {
            return 0;
        }
        
        public final void setQuantity(int p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getItemPhoto() {
            return null;
        }
        
        public final int component6() {
            return 0;
        }
        
        public final int getMaxQuantity() {
            return 0;
        }
        
        public final void setMaxQuantity(int p0) {
        }
        
        public final double getTotal() {
            return 0.0;
        }
    }
}