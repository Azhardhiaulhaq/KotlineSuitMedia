package com.example.kotlinsuitmedia.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinsuitmedia.model.Event

@Database(version = 1,entities = [Event::class])
abstract class EventDatabase : RoomDatabase() {
    companion object {

        fun get(context : Context) : EventDatabase {
            return Room.databaseBuilder(context,EventDatabase::class.java,"EventsDatabase")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }

    }

    abstract fun getEventDao() : EventDao
}