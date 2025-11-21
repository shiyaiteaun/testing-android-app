package com.awakencompany.data.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000f\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u001a\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ/\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u001a\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\'\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\"\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/awakencompany/data/dao/OrderDao;", "", "deleteOrder", "", "order", "Lcom/awakencompany/data/models/Order;", "(Lcom/awakencompany/data/models/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOrders", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnnualOrders", "year", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMonthlyOrders", "yearMonth", "getOrderById", "orderId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrdersByDateRange", "startDate", "", "endDate", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrdersByUsername", "username", "getOrdersByUsernameAndDateRange", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodayOrders", "getTodayOrdersByUsername", "getWeeklyOrders", "weekStart", "weekEnd", "insertOrder", "updateOrder", "app_debug"})
public abstract interface OrderDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders ORDER BY orderDate DESC")
    public abstract java.lang.Object getAllOrders(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE orderId = :orderId LIMIT 1")
    public abstract java.lang.Object getOrderById(int orderId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.awakencompany.data.models.Order> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE username = :username ORDER BY orderDate DESC")
    public abstract java.lang.Object getOrdersByUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE orderDate >= :startDate AND orderDate <= :endDate ORDER BY orderDate DESC")
    public abstract java.lang.Object getOrdersByDateRange(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE username = :username AND orderDate >= :startDate AND orderDate <= :endDate ORDER BY orderDate DESC")
    public abstract java.lang.Object getOrdersByUsernameAndDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String username, long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE date(orderDate/1000, \'unixepoch\') = date(\'now\') ORDER BY orderDate DESC")
    public abstract java.lang.Object getTodayOrders(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE username = :username AND date(orderDate/1000, \'unixepoch\') = date(\'now\') ORDER BY orderDate DESC")
    public abstract java.lang.Object getTodayOrdersByUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE orderDate >= :weekStart AND orderDate <= :weekEnd ORDER BY orderDate DESC")
    public abstract java.lang.Object getWeeklyOrders(long weekStart, long weekEnd, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE strftime(\'%Y-%m\', datetime(orderDate/1000, \'unixepoch\')) = :yearMonth ORDER BY orderDate DESC")
    public abstract java.lang.Object getMonthlyOrders(@org.jetbrains.annotations.NotNull()
    java.lang.String yearMonth, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM orders WHERE strftime(\'%Y\', datetime(orderDate/1000, \'unixepoch\')) = :year ORDER BY orderDate DESC")
    public abstract java.lang.Object getAnnualOrders(@org.jetbrains.annotations.NotNull()
    java.lang.String year, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.Order>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertOrder(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateOrder(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteOrder(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.Order order, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}