package com.awakencompany

import android.app.Application
import com.awakencompany.data.AppDatabase

class AwakenApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}

