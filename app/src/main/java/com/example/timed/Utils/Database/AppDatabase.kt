package com.example.timed.Utils.Database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MyEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myDao() : MyDao
}