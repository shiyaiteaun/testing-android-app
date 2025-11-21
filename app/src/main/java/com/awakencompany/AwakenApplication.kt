package com.awakencompany

import android.app.Application
import android.util.Log
import com.awakencompany.data.AppDatabase

class AwakenApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }

    override fun onCreate() {
        super.onCreate()
        
        // Set up global exception handler to catch crashes
        Thread.setDefaultUncaughtExceptionHandler { thread, exception ->
            Log.e("AwakenApp", "Uncaught exception in thread ${thread.name}", exception)
            exception.printStackTrace()
            
            // Log to file or send to crash reporting service
            android.util.Log.e("AwakenApp", "CRASH: ${exception.message}", exception)
            android.util.Log.e("AwakenApp", "Stack trace: ${exception.stackTraceToString()}")
            
            // Call default handler
            val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
            defaultHandler?.uncaughtException(thread, exception)
        }
        
        Log.d("AwakenApplication", "Application created")
    }
}

