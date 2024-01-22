package com.example.kolin2_3.data.models

import android.app.Application
import androidx.room.Room
import com.example.kolin2_3.data.local.room.AppDatabase

private const val DATABASE_NAME = "note_database"

class App : Application() {
    companion object {
        lateinit var db: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}