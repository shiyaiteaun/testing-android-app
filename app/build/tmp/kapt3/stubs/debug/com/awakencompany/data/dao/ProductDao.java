package com.awakencompany.data.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0019\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J!\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u001e\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\'\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u001e\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\"\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/awakencompany/data/dao/ProductDao;", "", "decreaseQuantity", "", "itemCode", "", "quantity", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteProduct", "product", "Lcom/awakencompany/data/models/Product;", "(Lcom/awakencompany/data/models/Product;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCategories", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllProducts", "getAvailableCategories", "getAvailableProducts", "getLowStockProducts", "threshold", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductByCode", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductsByCategory", "category", "increaseQuantity", "insertProduct", "", "searchAvailableProducts", "search", "searchAvailableProductsByCategory", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchProducts", "updateProduct", "app_debug"})
public abstract interface ProductDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM products ORDER BY itemName ASC")
    public abstract java.lang.Object getAllProducts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Product>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM products WHERE itemCode = :itemCode LIMIT 1")
    public abstract java.lang.Object getProductByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.awakencompany.data.models.Product> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM products WHERE quantity > 0 ORDER BY itemName ASC")
    public abstract java.lang.Object getAvailableProducts(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Product>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM products WHERE category = :category ORDER BY itemName ASC")
    public abstract java.lang.Object getProductsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Product>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM products WHERE itemCode LIKE \'%\' || :search || \'%\' OR itemName LIKE \'%\' || :search || \'%\' ORDER BY itemName ASC")
    public abstract java.lang.Object searchProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Product>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM products WHERE quantity > 0 AND (itemCode LIKE \'%\' || :search || \'%\' OR itemName LIKE \'%\' || :search || \'%\') ORDER BY itemName ASC")
    public abstract java.lang.Object searchAvailableProducts(@org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Product>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM products WHERE quantity > 0 AND category = :category AND (itemCode LIKE \'%\' || :search || \'%\' OR itemName LIKE \'%\' || :search || \'%\') ORDER BY itemName ASC")
    public abstract java.lang.Object searchAvailableProductsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Product>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT DISTINCT category FROM products WHERE category IS NOT NULL ORDER BY category ASC")
    public abstract java.lang.Object getAllCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT DISTINCT category FROM products WHERE quantity > 0 AND category IS NOT NULL ORDER BY category ASC")
    public abstract java.lang.Object getAvailableCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM products WHERE quantity <= :threshold ORDER BY quantity ASC")
    public abstract java.lang.Object getLowStockProducts(int threshold, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Product>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertProduct(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateProduct(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteProduct(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.Product product, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE products SET quantity = quantity - :quantity WHERE itemCode = :itemCode")
    public abstract java.lang.Object decreaseQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, int quantity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE products SET quantity = quantity + :quantity WHERE itemCode = :itemCode")
    public abstract java.lang.Object increaseQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, int quantity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}