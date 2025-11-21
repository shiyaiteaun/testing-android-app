package com.awakencompany.ui.admin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u001a\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010%\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\rH\u0002J\u0010\u0010\'\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J0\u0010*\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/awakencompany/ui/admin/UserManagementFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/awakencompany/databinding/FragmentUserManagementBinding;", "adapter", "Lcom/awakencompany/ui/admin/UsersAdapter;", "binding", "getBinding", "()Lcom/awakencompany/databinding/FragmentUserManagementBinding;", "database", "Lcom/awakencompany/data/AppDatabase;", "addUser", "", "username", "", "password", "fullName", "email", "phone", "deleteUser", "user", "Lcom/awakencompany/data/models/User;", "hashPassword", "loadUsers", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "searchUsers", "showAddUserDialog", "showDeleteDialog", "showEditDialog", "toggleUserStatus", "updateUser", "newPassword", "app_debug"})
public final class UserManagementFragment extends androidx.fragment.app.Fragment {
    private com.awakencompany.databinding.FragmentUserManagementBinding _binding;
    private com.awakencompany.data.AppDatabase database;
    private com.awakencompany.ui.admin.UsersAdapter adapter;
    
    public UserManagementFragment() {
        super();
    }
    
    private final com.awakencompany.databinding.FragmentUserManagementBinding getBinding() {
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
    
    private final void loadUsers() {
    }
    
    private final void searchUsers() {
    }
    
    private final void showAddUserDialog() {
    }
    
    private final void addUser(java.lang.String username, java.lang.String password, java.lang.String fullName, java.lang.String email, java.lang.String phone) {
    }
    
    private final void showEditDialog(com.awakencompany.data.models.User user) {
    }
    
    private final void updateUser(com.awakencompany.data.models.User user, java.lang.String newPassword, java.lang.String fullName, java.lang.String email, java.lang.String phone) {
    }
    
    private final void showDeleteDialog(com.awakencompany.data.models.User user) {
    }
    
    private final void deleteUser(com.awakencompany.data.models.User user) {
    }
    
    private final void toggleUserStatus(com.awakencompany.data.models.User user) {
    }
    
    private final java.lang.String hashPassword(java.lang.String password) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}