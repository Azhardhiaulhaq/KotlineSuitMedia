package com.example.kotlinsuitmedia.model

import android.text.TextUtils

class User (override val name:String) : IUser  {
    override val isDataValid: Boolean
        get() = (!TextUtils.isEmpty(name))

}