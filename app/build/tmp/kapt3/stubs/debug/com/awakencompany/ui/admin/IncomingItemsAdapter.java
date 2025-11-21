package com.awakencompany.ui.admin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/awakencompany/ui/admin/IncomingItemsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/awakencompany/data/models/IncomingItem;", "Lcom/awakencompany/ui/admin/IncomingItemsAdapter$IncomingItemViewHolder;", "database", "Lcom/awakencompany/data/AppDatabase;", "onEdit", "Lkotlin/Function1;", "", "onDelete", "(Lcom/awakencompany/data/AppDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "IncomingItemDiffCallback", "IncomingItemViewHolder", "app_debug"})
public final class IncomingItemsAdapter extends androidx.recyclerview.widget.ListAdapter<com.awakencompany.data.models.IncomingItem, com.awakencompany.ui.admin.IncomingItemsAdapter.IncomingItemViewHolder> {
    private final com.awakencompany.data.AppDatabase database = null;
    private final kotlin.jvm.functions.Function1<com.awakencompany.data.models.IncomingItem, kotlin.Unit> onEdit = null;
    private final kotlin.jvm.functions.Function1<com.awakencompany.data.models.IncomingItem, kotlin.Unit> onDelete = null;
    
    public IncomingItemsAdapter(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.AppDatabase database, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.awakencompany.data.models.IncomingItem, kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.awakencompany.data.models.IncomingItem, kotlin.Unit> onDelete) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.awakencompany.ui.admin.IncomingItemsAdapter.IncomingItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.awakencompany.ui.admin.IncomingItemsAdapter.IncomingItemViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/awakencompany/ui/admin/IncomingItemsAdapter$IncomingItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/awakencompany/databinding/ItemIncomingBinding;", "database", "Lcom/awakencompany/data/AppDatabase;", "onEdit", "Lkotlin/Function1;", "Lcom/awakencompany/data/models/IncomingItem;", "", "onDelete", "(Lcom/awakencompany/databinding/ItemIncomingBinding;Lcom/awakencompany/data/AppDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "formatCurrency", "", "amount", "", "formatDate", "timestamp", "", "app_debug"})
    public static final class IncomingItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.awakencompany.databinding.ItemIncomingBinding binding = null;
        private final com.awakencompany.data.AppDatabase database = null;
        private final kotlin.jvm.functions.Function1<com.awakencompany.data.models.IncomingItem, kotlin.Unit> onEdit = null;
        private final kotlin.jvm.functions.Function1<com.awakencompany.data.models.IncomingItem, kotlin.Unit> onDelete = null;
        
        public IncomingItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.awakencompany.databinding.ItemIncomingBinding binding, @org.jetbrains.annotations.NotNull()
        com.awakencompany.data.AppDatabase database, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.awakencompany.data.models.IncomingItem, kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.awakencompany.data.models.IncomingItem, kotlin.Unit> onDelete) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.IncomingItem item) {
        }
        
        private final java.lang.String formatDate(long timestamp) {
            return null;
        }
        
        private final java.lang.String formatCurrency(double amount) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/awakencompany/ui/admin/IncomingItemsAdapter$IncomingItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/awakencompany/data/models/IncomingItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class IncomingItemDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.awakencompany.data.models.IncomingItem> {
        
        public IncomingItemDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.IncomingItem oldItem, @org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.IncomingItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.IncomingItem oldItem, @org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.IncomingItem newItem) {
            return false;
        }
    }
}