package com.awakencompany.ui.user;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J(\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J \u0010%\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\u0018\u0010\'\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/awakencompany/ui/user/CartFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/awakencompany/databinding/FragmentCartBinding;", "adapter", "Lcom/awakencompany/ui/user/CartAdapter;", "binding", "getBinding", "()Lcom/awakencompany/databinding/FragmentCartBinding;", "database", "Lcom/awakencompany/data/AppDatabase;", "prefs", "Landroid/content/SharedPreferences;", "loadCart", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "processOrder", "customerName", "", "customerAddress", "customerPhone", "paymentMethod", "removeFromCart", "itemCode", "showCustomerInfoDialog", "showPaymentDialog", "updateCartBadge", "updateQuantity", "newQuantity", "", "updateTotal", "app_debug"})
public final class CartFragment extends androidx.fragment.app.Fragment {
    private com.awakencompany.databinding.FragmentCartBinding _binding;
    private com.awakencompany.data.AppDatabase database;
    private android.content.SharedPreferences prefs;
    private com.awakencompany.ui.user.CartAdapter adapter;
    
    public CartFragment() {
        super();
    }
    
    private final com.awakencompany.databinding.FragmentCartBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void loadCart() {
    }
    
    private final void updateQuantity(java.lang.String itemCode, int newQuantity) {
    }
    
    private final void removeFromCart(java.lang.String itemCode) {
    }
    
    private final void updateTotal() {
    }
    
    private final void updateCartBadge() {
    }
    
    private final void showCustomerInfoDialog() {
    }
    
    private final void showPaymentDialog(java.lang.String customerName, java.lang.String customerAddress, java.lang.String customerPhone) {
    }
    
    private final void processOrder(java.lang.String customerName, java.lang.String customerAddress, java.lang.String customerPhone, java.lang.String paymentMethod) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}