package com.awakencompany.data.models;

import java.lang.System;

@androidx.room.Entity(tableName = "sold_items", foreignKeys = {@androidx.room.ForeignKey(entity = com.awakencompany.data.models.Product.class, childColumns = {"itemCode"}, onDelete = 5, parentColumns = {"itemCode"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\t\u0010!\u001a\u00020\fH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J[\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00d6\u0001J\t\u0010(\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006)"}, d2 = {"Lcom/awakencompany/data/models/SoldItem;", "", "saleId", "", "itemCode", "", "itemName", "quantitySold", "unitPrice", "", "totalPrice", "saleDate", "", "username", "(ILjava/lang/String;Ljava/lang/String;IDDJLjava/lang/String;)V", "getItemCode", "()Ljava/lang/String;", "getItemName", "getQuantitySold", "()I", "getSaleDate", "()J", "getSaleId", "getTotalPrice", "()D", "getUnitPrice", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class SoldItem {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int saleId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String itemCode = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String itemName = null;
    private final int quantitySold = 0;
    private final double unitPrice = 0.0;
    private final double totalPrice = 0.0;
    private final long saleDate = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String username = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.awakencompany.data.models.SoldItem copy(int saleId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, @org.jetbrains.annotations.NotNull()
    java.lang.String itemName, int quantitySold, double unitPrice, double totalPrice, long saleDate, @org.jetbrains.annotations.Nullable()
    java.lang.String username) {
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
    
    public SoldItem(int saleId, @org.jetbrains.annotations.NotNull()
    java.lang.String itemCode, @org.jetbrains.annotations.NotNull()
    java.lang.String itemName, int quantitySold, double unitPrice, double totalPrice, long saleDate, @org.jetbrains.annotations.Nullable()
    java.lang.String username) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getSaleId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemName() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getQuantitySold() {
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
    
    public final double getTotalPrice() {
        return 0.0;
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final long getSaleDate() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUsername() {
        return null;
    }
}