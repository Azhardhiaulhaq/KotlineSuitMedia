package com.example.kotlinsuitmedia.repo

import android.content.Context
import android.util.Log
import com.example.kotlinsuitmedia.model.Event
import com.example.kotlinsuitmedia.room.EventDatabase

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