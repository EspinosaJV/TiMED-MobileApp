package com.example.timed.Utils.Database

import android.content.Context
import androidx.room.Room

object DatabaseHelper {
    @Volatile
    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        return instance ?: synchronized(this) {
            val newInstance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "timed_database"
            ).build()
            instance = newInstance
            newInstance
        }
    }


}