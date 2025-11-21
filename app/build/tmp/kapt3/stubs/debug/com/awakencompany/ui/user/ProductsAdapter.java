package com.awakencompany.ui.user;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/awakencompany/ui/user/ProductsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/awakencompany/data/models/Product;", "Lcom/awakencompany/ui/user/ProductsAdapter$ProductViewHolder;", "database", "Lcom/awakencompany/data/AppDatabase;", "onAddToCart", "Lkotlin/Function1;", "", "(Lcom/awakencompany/data/AppDatabase;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ProductDiffCallback", "ProductViewHolder", "app_debug"})
public final class ProductsAdapter extends androidx.recyclerview.widget.ListAdapter<com.awakencompany.data.models.Product, com.awakencompany.ui.user.ProductsAdapter.ProductViewHolder> {
    private final com.awakencompany.data.AppDatabase database = null;
    private final kotlin.jvm.functions.Function1<com.awakencompany.data.models.Product, kotlin.Unit> onAddToCart = null;
    
    public ProductsAdapter(@org.jetbrains.annotations.NotNull()
    com.awakencompany.data.AppDatabase database, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.awakencompany.data.models.Product, kotlin.Unit> onAddToCart) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.awakencompany.ui.user.ProductsAdapter.ProductViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.awakencompany.ui.user.ProductsAdapter.ProductViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/awakencompany/ui/user/ProductsAdapter$ProductViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/awakencompany/databinding/ItemProductBinding;", "onAddToCart", "Lkotlin/Function1;", "Lcom/awakencompany/data/models/Product;", "", "(Lcom/awakencompany/databinding/ItemProductBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "product", "app_debug"})
    public static final class ProductViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.awakencompany.databinding.ItemProductBinding binding = null;
        private final kotlin.jvm.functions.Function1<com.awakencompany.data.models.Product, kotlin.Unit> onAddToCart = null;
        
        public ProductViewHolder(@org.jetbrains.annotations.NotNull()
        com.awakencompany.databinding.ItemProductBinding binding, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.awakencompany.data.models.Product, kotlin.Unit> onAddToCart) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.Product product) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/awakencompany/ui/user/ProductsAdapter$ProductDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/awakencompany/data/models/Product;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ProductDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.awakencompany.data.models.Product> {
        
        public ProductDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.Product oldItem, @org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.Product newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.Product oldItem, @org.jetbrains.annotations.NotNull()
        com.awakencompany.data.models.Product newItem) {
            return false;
        }
    }
}