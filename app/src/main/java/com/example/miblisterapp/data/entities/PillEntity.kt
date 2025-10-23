package com.example.miblisterapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "pills", indices = [Index(value = ["cycle_id", "day_index"], unique = true)])
data class PillEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "cycle_id")
    val cycleId: Long = 0L,

    @ColumnInfo(name = "day_index")
    val dayIndex: Int = 0,

    @ColumnInfo(name = "taken")
    val taken: Boolean = false,

    @ColumnInfo(name = "taken_at")
    val takenAt: Long? = null,

    @ColumnInfo(name = "note")
    val note: String? = null
)