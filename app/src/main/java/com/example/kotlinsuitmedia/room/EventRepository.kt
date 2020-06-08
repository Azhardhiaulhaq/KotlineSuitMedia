package com.example.kotlinsuitmedia.room

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.room.Room
import com.example.kotlinsuitmedia.model.Event

class EventRepository (val context:Context){
//    private val eventDatabase : EventDatabase by lazy {EventDatabase.getInstance()}
    val con : Context
    init {
        con = context
    }
    fun insertEvent (event : Event){
        Log.d("Inside ", "Event Repository")
    EventDatabase.get(con).getEventDao().insertEvent(event)
    }

    fun getEvent() : List<Event>{
        return EventDatabase.get(con).getEventDao().getEvent()
    }

}