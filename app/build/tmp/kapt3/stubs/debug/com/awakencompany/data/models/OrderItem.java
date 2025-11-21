package com.awakencompany.data.models;

import java.lang.System;

@androidx.room.Entity(tableName = "order_items", foreignKeys = {@androidx.room.ForeignKey(entity = com.awakencompany.data.models.Order.class, childColumns = {"orderId"}, onDelete = 5, parentColumns = {"orderId"}), @androidx.room.ForeignKey(entity = com.awakencompany.data.models.Product.class, childColumns = {"itemCode"}, onDelete = 5, parentColumns = {"itemCode"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010 \u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/awakencompany/data/models/OrderItem;", "", "orderItemId", "", "orderId", "itemCode", "", "quantity", "unitPrice", "", "total", "(IILjava/lang/String;IDD)V", "getItemCode", "()Ljava/lang/String;", "getOrderId", "()I", "getOrderItemId", "getQuantity", "getTotal", "()D", "getUnitPrice", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class OrderItem {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int orderItemId = 0;
    private final int orderId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String itemCode = null;
    private final int quantity = 0;
    private final double unitPrice = 0.0;
    private final double total = 0.0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.awakencompany.data.models.OrderItem copy(int orderItemId, int orderId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, int quantity, double unitPrice, double total) {
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
    
    public OrderItem(int orderItemId, int orderId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, int quantity, double unitPrice, double total) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getOrderItemId() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getOrderId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemCode() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getQuantity() {
        return 0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double getUnitPrice() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double getTotal() {
        return 0.0;
    }
}