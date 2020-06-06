package com.example.kotlinsuitmedia.presenter

import android.content.Intent

interface ISelectEventAndGuestPresenter {
    fun showPhone(name : String, birthdate:String)
    fun showName(intent : Intent)
    fun showResult (requestCode : Int, resultCode : Int, data : Intent?)
}