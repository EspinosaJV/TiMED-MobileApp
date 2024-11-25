package com.example.timed.Utils.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.timed.Utils.Database.Database.Medicine

@Dao
interface MyDao {
    @Insert
    suspend fun insertMedicine(medicine: Medicine)

    @Query("SELECT * FROM Medicine")
    suspend fun getAllMedicines(): List<Medicine>
}