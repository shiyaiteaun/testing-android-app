package com.awakencompany;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/awakencompany/AwakenApplication;", "Landroid/app/Application;", "()V", "database", "Lcom/awakencompany/data/AppDatabase;", "getDatabase", "()Lcom/awakencompany/data/AppDatabase;", "database$delegate", "Lkotlin/Lazy;", "onCreate", "", "app_debug"})
public final class AwakenApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    
    public AwakenApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.awakencompany.data.AppDatabase getDatabase() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
}