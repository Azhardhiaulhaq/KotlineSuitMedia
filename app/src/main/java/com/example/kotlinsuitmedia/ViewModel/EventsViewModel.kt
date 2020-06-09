package com.example.kotlinsuitmedia.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinsuitmedia.model.EventsProperty

class EventsViewModel : ViewModel() {
    val eventsData = MutableLiveData<List<EventsProperty>>()


    init {
        getEventProperties()
    }

    private fun getEventProperties(){
            var eventList : MutableList<EventsProperty> = mutableListOf()
            eventList.add(
                EventsProperty(
                    "Hangout Around Town", "March 23, 2020",
                    "https://image.flaticon.com/icons/png/512/1458/1458512.png",
                    "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet..."
                )
            )
            eventList.add(
                EventsProperty(
                    "Meeting 1", "May 01, 2020",
                    "https://image.flaticon.com/icons/png/512/115/115902.png",
                    "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet..."
                )
            )
            eventList.add(
                EventsProperty(
                    "Football MatchDay", "June 02, 2020",
                    "https://img.favpng.com/10/3/10/football-player-sport-computer-icons-png-favpng-7ypZt7RGHDMnDrmP3v6L3WX2H.jpg",
                    "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet..."
                )
            )
            eventList.add(
                EventsProperty(
                    "Badminton MatchDay", "June 04, 2020",
                    "https://image.flaticon.com/icons/png/512/121/121489.png",
                    "This is version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquer. Aenean gravida nibh vel velt auctor aliquet..."
                )
            )
            eventsData.setValue(eventList)
        }
    }

