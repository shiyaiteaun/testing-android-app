package com.awakencompany.data.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0018\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J/\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u001c\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0018\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001f\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010 \u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J)\u0010!\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0011\u0010\"\u001a\u00020#H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010$\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J)\u0010%\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0011\u0010&\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010\'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J)\u0010(\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0019\u0010)\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/awakencompany/data/dao/SoldItemDao;", "", "deleteSoldItem", "", "soldItem", "Lcom/awakencompany/data/models/SoldItem;", "(Lcom/awakencompany/data/models/SoldItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSoldItems", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSoldItemById", "saleId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSoldItemsByDateRange", "startDate", "", "endDate", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSoldItemsByMonth", "yearMonth", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSoldItemsByUsername", "username", "getSoldItemsByUsernameAndDateRange", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSoldItemsByYear", "year", "getTodaySoldItems", "getTodaySoldItemsByUsername", "getTotalItemsSold", "getTotalItemsSoldByDateRange", "getTotalItemsSoldByUsernameAndDateRange", "getTotalSales", "", "getTotalSalesByDateRange", "getTotalSalesByUsernameAndDateRange", "getTotalTransactions", "getTotalTransactionsByDateRange", "getTotalTransactionsByUsernameAndDateRange", "insertSoldItem", "updateSoldItem", "app_debug"})
public abstract interface SoldItemDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items ORDER BY saleDate DESC")
    public abstract java.lang.Object getAllSoldItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.SoldItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items WHERE saleId = :saleId LIMIT 1")
    public abstract java.lang.Object getSoldItemById(int saleId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.awakencompany.data.models.SoldItem> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items WHERE username = :username ORDER BY saleDate DESC")
    public abstract java.lang.Object getSoldItemsByUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.SoldItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items WHERE saleDate >= :startDate AND saleDate <= :endDate ORDER BY saleDate DESC")
    public abstract java.lang.Object getSoldItemsByDateRange(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.SoldItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items WHERE username = :username AND saleDate >= :startDate AND saleDate <= :endDate ORDER BY saleDate DESC")
    public abstract java.lang.Object getSoldItemsByUsernameAndDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String username, long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.SoldItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items WHERE date(saleDate/1000, \'unixepoch\') = date(\'now\') ORDER BY saleDate DESC")
    public abstract java.lang.Object getTodaySoldItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.SoldItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items WHERE username = :username AND date(saleDate/1000, \'unixepoch\') = date(\'now\') ORDER BY saleDate DESC")
    public abstract java.lang.Object getTodaySoldItemsByUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.SoldItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items")
    public abstract java.lang.Object getTotalSales(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(COUNT(*), 0) FROM sold_items")
    public abstract java.lang.Object getTotalTransactions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items")
    public abstract java.lang.Object getTotalItemsSold(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items WHERE saleDate >= :startDate AND saleDate <= :endDate")
    public abstract java.lang.Object getTotalSalesByDateRange(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(COUNT(*), 0) FROM sold_items WHERE saleDate >= :startDate AND saleDate <= :endDate")
    public abstract java.lang.Object getTotalTransactionsByDateRange(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items WHERE saleDate >= :startDate AND saleDate <= :endDate")
    public abstract java.lang.Object getTotalItemsSoldByDateRange(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(SUM(totalPrice), 0) FROM sold_items WHERE username = :username AND saleDate >= :startDate AND saleDate <= :endDate")
    public abstract java.lang.Object getTotalSalesByUsernameAndDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String username, long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(COUNT(*), 0) FROM sold_items WHERE username = :username AND saleDate >= :startDate AND saleDate <= :endDate")
    public abstract java.lang.Object getTotalTransactionsByUsernameAndDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String username, long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT COALESCE(SUM(quantitySold), 0) FROM sold_items WHERE username = :username AND saleDate >= :startDate AND saleDate <= :endDate")
    public abstract java.lang.Object getTotalItemsSoldByUsernameAndDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String username, long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items WHERE strftime(\'%Y-%m\', datetime(saleDate/1000, \'unixepoch\')) = :yearMonth ORDER BY saleDate DESC")
    public abstract java.lang.Object getSoldItemsByMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String yearMonth, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.SoldItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM sold_items WHERE strftime(\'%Y\', datetime(saleDate/1000, \'unixepoch\')) = :year ORDER BY saleDate DESC")
    public abstract java.lang.Object getSoldItemsByYear(@org.jetbrains.annotations.NotNull()
    java.lang.String year, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.SoldItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertSoldItem(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.SoldItem soldItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateSoldItem(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.SoldItem soldItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteSoldItem(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.SoldItem soldItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}