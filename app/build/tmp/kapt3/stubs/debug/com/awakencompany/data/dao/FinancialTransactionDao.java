package com.awakencompany.data.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ#\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ#\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/awakencompany/data/dao/FinancialTransactionDao;", "", "deleteTransaction", "", "transaction", "Lcom/awakencompany/data/models/FinancialTransaction;", "(Lcom/awakencompany/data/models/FinancialTransaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTransactions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalExpense", "", "startDate", "", "endDate", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalIncome", "getTransactionById", "transactionId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransactionsByDateRange", "getTransactionsByType", "type", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTransaction", "updateTransaction", "app_debug"})
public abstract interface FinancialTransactionDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM financial_transactions ORDER BY transactionDate DESC")
    public abstract java.lang.Object getAllTransactions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.FinancialTransaction>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM financial_transactions WHERE transactionId = :transactionId LIMIT 1")
    public abstract java.lang.Object getTransactionById(int transactionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.awakencompany.data.models.FinancialTransaction> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM financial_transactions WHERE type = :type ORDER BY transactionDate DESC")
    public abstract java.lang.Object getTransactionsByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.FinancialTransaction>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM financial_transactions WHERE transactionDate >= :startDate AND transactionDate <= :endDate ORDER BY transactionDate DESC")
    public abstract java.lang.Object getTransactionsByDateRange(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.awakencompany.data.models.FinancialTransaction>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT SUM(amount) FROM financial_transactions WHERE type = \'income\' AND transactionDate >= :startDate AND transactionDate <= :endDate")
    public abstract java.lang.Object getTotalIncome(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT SUM(amount) FROM financial_transactions WHERE type = \'expense\' AND transactionDate >= :startDate AND transactionDate <= :endDate")
    public abstract java.lang.Object getTotalExpense(long startDate, long endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.FinancialTransaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.FinancialTransaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteTransaction(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.models.FinancialTransaction transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}