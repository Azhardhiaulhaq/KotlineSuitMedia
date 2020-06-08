package com.example.kotlinsuitmedia.presenter

import android.content.Context
import android.os.AsyncTask
import com.example.kotlinsuitmedia.model.Event
import com.example.kotlinsuitmedia.room.EventDatabase
import com.example.kotlinsuitmedia.repo.EventRepository
import com.example.kotlinsuitmedia.view.IEventView

class EventPresenter(context : Context) {
    val event_view = context as IEventView
    val app = context
    val eventRepository  =
        EventRepository(context)

    fun addData(){
        eventRepository.insertEvent(Event("Hangout Around Town","March 23, 2020",
            "https://image.flaticon.com/icons/png/512/1458/1458512.png",
            "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet..."))
        eventRepository.insertEvent(Event("Meeting 1","May 01, 2020",
            "https://image.flaticon.com/icons/png/512/115/115902.png",
            "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet..."))
        eventRepository.insertEvent(Event("Football MatchDay","June 02, 2020",
            "https://img.favpng.com/10/3/10/football-player-sport-computer-icons-png-favpng-7ypZt7RGHDMnDrmP3v6L3WX2H.jpg",
            "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet..."))
        eventRepository.insertEvent(Event("Badminton MatchDay","June 04, 2020",
            "https://image.flaticon.com/icons/png/512/121/121489.png",
            "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet..."))
    }
    fun getData(){
        event_view.onDataCompleted(eventRepository.getEvent())
    }

    class InsertEventData(val data : Event, val application : Context) :
        AsyncTask<Void, Void, Void>(){
        override fun doInBackground(vararg p0: Void?): Void? {
            EventDatabase.get(application).getEventDao().insertEvent(data)

            return null
        }

    }
}
