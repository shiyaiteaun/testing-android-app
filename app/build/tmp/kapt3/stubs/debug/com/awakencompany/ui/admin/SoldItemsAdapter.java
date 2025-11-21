package com.awakencompany.ui.admin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/awakencompany/ui/admin/SoldItemsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/awakencompany/data/models/SoldItem;", "Lcom/awakencompany/ui/admin/SoldItemsAdapter$SoldItemViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "SoldItemDiffCallback", "SoldItemViewHolder", "app_debug"})
public final class SoldItemsAdapter extends androidx.recyclerview.widget.ListAdapter<com.awakencompany.data.models.SoldItem, com.awakencompany.ui.admin.SoldItemsAdapter.SoldItemViewHolder> {
    
    public SoldItemsAdapter() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.awakencompany.ui.admin.SoldItemsAdapter.SoldItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.awakencompany.ui.admin.SoldItemsAdapter.SoldItemViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/awakencompany/ui/admin/SoldItemsAdapter$SoldItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/awakencompany/databinding/ItemSoldBinding;", "(Lcom/awakencompany/databinding/ItemSoldBinding;)V", "bind", "", "item", "Lcom/awakencompany/data/models/SoldItem;", "formatCurrency", "", "amount", "", "formatDate", "timestamp", "", "app_debug"})
    public static final class SoldItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.awakencompany.databinding.ItemSoldBinding binding = null;
        
        public SoldItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.awakencompany.databinding.ItemSoldBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.SoldItem item) {
        }
        
        private final java.lang.String formatDate(long timestamp) {
            return null;
        }
        
        private final java.lang.String formatCurrency(double amount) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/awakencompany/ui/admin/SoldItemsAdapter$SoldItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/awakencompany/data/models/SoldItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class SoldItemDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.awakencompany.data.models.SoldItem> {
        
        public SoldItemDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.SoldItem oldItem, @org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.SoldItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.SoldItem oldItem, @org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.SoldItem newItem) {
            return false;
        }
    }
}