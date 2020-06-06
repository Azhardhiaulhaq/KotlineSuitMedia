package com.example.kotlinsuitmedia.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinsuitmedia.model.SelectedGuest
import com.example.kotlinsuitmedia.view.ISelectEventAndGuestView

class SelectEventAndGuestPresenter (internal var iselecteventandguestview : ISelectEventAndGuestView)
    : ISelectEventAndGuestPresenter {
    private var GET_GUEST : Int = 1
    private var GET_EVENT : Int = 2

    override fun showPhone(name:String, birthdate:String) {
        val selected_guest = SelectedGuest(name,birthdate)
        iselecteventandguestview.onPhoneResult(selected_guest.phone)
    }

    override fun showName(intent: Intent) {
        if (intent.hasExtra("username")){
            iselecteventandguestview.onNameResult(intent.getExtras()?.getString("username").toString())
        }
    }

    override fun showResult(requestCode: Int, resultCode: Int, data : Intent?) {
        if(requestCode == GET_GUEST){
            if(resultCode == AppCompatActivity.RESULT_OK){
                val name : String? = data?.getExtras()?.getString("guestName")
                val birthDate: String? = data?.getExtras()?.getString("guestBirthDate")
                iselecteventandguestview.onGetGuestResult(name.toString(),birthDate.toString())
            }
        } else if (requestCode == GET_EVENT) {
            if(resultCode == AppCompatActivity.RESULT_OK){
                val eventName : String? = data?.getExtras()?.getString("eventName")
                iselecteventandguestview.onGetEventResult(eventName.toString())
            }
        }
    }

}