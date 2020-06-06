package com.example.kotlinsuitmedia.view

import com.example.kotlinsuitmedia.model.Event
import com.example.kotlinsuitmedia.model.Guest

interface IEventView {
    fun onDataCompleted(item: List<Event>)
}