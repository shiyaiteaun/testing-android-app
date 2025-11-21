package com.awakencompany.data;

import java.lang.System;

@androidx.room.Database(entities = {com.awakencompany.data.models.Admin.class, com.awakencompany.data.models.User.class, com.awakencompany.data.models.Product.class, com.awakencompany.data.models.Order.class, com.awakencompany.data.models.OrderItem.class, com.awakencompany.data.models.IncomingItem.class, com.awakencompany.data.models.SoldItem.class, com.awakencompany.data.models.FinancialTransaction.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0014"}, d2 = {"Lcom/awakencompany/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "adminDao", "Lcom/awakencompany/data/dao/AdminDao;", "financialTransactionDao", "Lcom/awakencompany/data/dao/FinancialTransactionDao;", "incomingItemDao", "Lcom/awakencompany/data/dao/IncomingItemDao;", "orderDao", "Lcom/awakencompany/data/dao/OrderDao;", "orderItemDao", "Lcom/awakencompany/data/dao/OrderItemDao;", "productDao", "Lcom/awakencompany/data/dao/ProductDao;", "soldItemDao", "Lcom/awakencompany/data/dao/SoldItemDao;", "userDao", "Lcom/awakencompany/data/dao/UserDao;", "Companion", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.awakencompany.data.AppDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.awakencompany.data.AppDatabase INSTANCE;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.awakencompany.data.dao.AdminDao adminDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.awakencompany.data.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.awakencompany.data.dao.ProductDao productDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.awakencompany.data.dao.OrderDao orderDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.awakencompany.data.dao.OrderItemDao orderItemDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.awakencompany.data.dao.IncomingItemDao incomingItemDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.awakencompany.data.dao.SoldItemDao soldItemDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.awakencompany.data.dao.FinancialTransactionDao financialTransactionDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/awakencompany/data/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/awakencompany/data/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "hashPassword", "", "password", "initializeDefaultAdmin", "", "adminDao", "Lcom/awakencompany/data/dao/AdminDao;", "(Lcom/awakencompany/data/dao/AdminDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.awakencompany.data.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final java.lang.Object initializeDefaultAdmin(com.awakencompany.data.dao.AdminDao adminDao, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return null;
        }
        
        private final java.lang.String hashPassword(java.lang.String password) {
            return null;
        }
    }
}