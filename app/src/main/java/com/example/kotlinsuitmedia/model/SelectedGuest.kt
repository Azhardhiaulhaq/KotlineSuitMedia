package com.example.kotlinsuitmedia.model

import android.text.TextUtils

class SelectedGuest (override val name :String, override val birthdate : String ) : ISelectedGuest {
    override val phone: String
        get() = ( getPhoneType(birthdate)
        )

    private fun getPhoneType(birthdate : String) :String {
        val arrBirthDate =
            birthdate!!.split("-".toRegex(), 3).toTypedArray()
        val date = arrBirthDate[2].toInt()
        if (date % 2 == 0) {
           return "blackberry"
        } else if (date % 3 == 0) {
            return "android"
        } else if (date % 2 == 0 && date % 3 == 0) {
            return "iOS"
        } else {
            return "feature phone"
        }
    }
}