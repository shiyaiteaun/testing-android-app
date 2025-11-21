package com.awakencompany.data.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0019\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u001b\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/awakencompany/data/dao/IncomingItemDao;", "", "deleteIncomingItem", "", "incomingItem", "Lcom/awakencompany/data/models/IncomingItem;", "(Lcom/awakencompany/data/models/IncomingItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllIncomingItems", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncomingItemById", "incomingId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncomingItemsByDateRange", "startDate", "", "endDate", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncomingItemsByItemCode", "itemCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertIncomingItem", "searchIncomingItemsByInvoiceNo", "invoiceNo", "searchIncomingItemsBySupplier", "supplier", "updateIncomingItem", "app_debug"})
public abstract interface IncomingItemDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM incoming_items ORDER BY incomingDate DESC")
    public abstract java.lang.Object getAllIncomingItems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.IncomingItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM incoming_items WHERE incomingId = :incomingId LIMIT 1")
    public abstract java.lang.Object getIncomingItemById(int incomingId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.awakencompany.data.models.IncomingItem> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM incoming_items WHERE itemCode = :itemCode ORDER BY incomingDate DESC")
    public abstract java.lang.Object getIncomingItemsByItemCode(@org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.IncomingItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM incoming_items WHERE incomingDate >= :startDate AND incomingDate <= :endDate ORDER BY incomingDate DESC")
    public abstract java.lang.Object getIncomingItemsByDateRange(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.IncomingItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM incoming_items WHERE supplier LIKE \'%\' || :supplier || \'%\' ORDER BY incomingDate DESC")
    public abstract java.lang.Object searchIncomingItemsBySupplier(@org.jetbrains.annotations.NotNull()
    java.lang.String supplier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.IncomingItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM incoming_items WHERE invoiceNo LIKE \'%\' || :invoiceNo || \'%\' ORDER BY incomingDate DESC")
    public abstract java.lang.Object searchIncomingItemsByInvoiceNo(@org.jetbrains.annotations.NotNull()
    java.lang.String invoiceNo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.IncomingItem>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertIncomingItem(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.IncomingItem incomingItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateIncomingItem(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.IncomingItem incomingItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteIncomingItem(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.IncomingItem incomingItem, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}