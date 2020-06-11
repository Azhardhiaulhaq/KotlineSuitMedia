package com.example.kotlinsuitmedia.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinsuitmedia.model.GuestProperty

@Database(entities = arrayOf(GuestProperty::class), version = 1, exportSchema = false)
public abstract class GuestDatabase : RoomDatabase() {
    abstract fun getGuestDao() : GuestDao

    companion object {
        @Volatile
        private var INSTANCE: GuestDatabase? = null

        fun getGuestDatabase(context : Context) : GuestDatabase {
            val tempInstance = INSTANCE
            if ( tempInstance != null) {
                return tempInstance
            }
            synchronized (this) {
                val instance = Room.databaseBuilder(context.applicationContext,GuestDatabase::class.java,
                "guest_database").allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}