package com.example.kotlinsuitmedia.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinsuitmedia.model.GuestProperty

class UserViewModel : ViewModel() {
    val userName = MutableLiveData<String>()
//    init {
//        userName.value = "Test"
//    }

    fun setUserName(name : String){
        userName.setValue(name)
    }
}