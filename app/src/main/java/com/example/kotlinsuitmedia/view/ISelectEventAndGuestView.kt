package com.example.kotlinsuitmedia.view

interface ISelectEventAndGuestView {
    fun onPhoneResult(phone : String)
    fun onNameResult(name : String)
    fun onGetGuestResult(name : String, birthdate : String)
    fun onGetEventResult(eventname : String)
}