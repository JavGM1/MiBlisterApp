package com.example.miblisterapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.miblisterapp.data.entities.PillEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PillDao {
    @Query("SELECT * FROM pills ORDER BY day_index ASC")
    fun getAll(): Flow<List<PillEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pill: PillEntity): Long
}