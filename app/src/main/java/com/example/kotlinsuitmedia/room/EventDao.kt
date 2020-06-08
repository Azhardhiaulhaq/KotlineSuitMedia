package com.example.kotlinsuitmedia.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinsuitmedia.model.Event

@Dao
interface EventDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(event : Event) : Long

    @Query("SELECT * FROM EventTable")
    fun getEvent() : List<Event>
}