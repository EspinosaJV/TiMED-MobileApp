package com.example.timed.Utils.Database.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicine(
    @PrimaryKey val id: Int,
    val name: String,
)