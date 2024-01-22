package com.example.kolin2_3.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kolin2_3.data.local.room.dao.NoteDao
import com.example.kolin2_3.data.local.room.entities.Note

@Database(entities = [Note::class], version = 2, exportSchema = false)

abstract class AppDatabase:RoomDatabase() {
    abstract fun noteDao(): NoteDao
     }