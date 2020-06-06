package com.example.kotlinsuitmedia.view

import com.example.kotlinsuitmedia.model.Guest

interface IGuestView {
    fun onDataCompletedOnAPI(item: List<Guest>?)
    fun onDataErrorOnAPI(throwable : Throwable)
}