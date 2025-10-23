package com.example.miblisterapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.miblisterapp.data.dao.PillDao
import com.example.miblisterapp.data.entities.PillEntity

@Database(entities = [PillEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pillDao(): PillDao
}