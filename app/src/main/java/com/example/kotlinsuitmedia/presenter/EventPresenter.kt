package com.example.kotlinsuitmedia.presenter

import android.content.Context
import com.example.kotlinsuitmedia.model.Event
import com.example.kotlinsuitmedia.view.IEventView

class EventPresenter(context : Context) {
    val event_view = context as IEventView
    
    fun getData(){
        var eventList : MutableList<Event> = mutableListOf()
        eventList.add(
            Event("Hangout Around Town","March 23, 2020",
            "https://image.flaticon.com/icons/png/512/1458/1458512.png",
            "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet...")
        )
        eventList.add(
            Event("Meeting 1","May 01, 2020",
            "https://image.flaticon.com/icons/png/512/115/115902.png",
            "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet...")
        )
        eventList.add(
            Event("Football MatchDay","June 02, 2020",
            "https://img.favpng.com/10/3/10/football-player-sport-computer-icons-png-favpng-7ypZt7RGHDMnDrmP3v6L3WX2H.jpg",
            "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet...")
        )
        eventList.add(
            Event("Badminton MatchDay","June 04, 2020",
            "https://image.flaticon.com/icons/png/512/121/121489.png",
            "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet...")
        )

        event_view.onDataCompleted(eventList)
    }
}