package com.example.kotlinsuitmedia.repository

import android.content.Context
import android.util.Log
import com.example.kotlinsuitmedia.model.GuestProperty
import com.example.kotlinsuitmedia.model.room.GuestDao
import com.example.kotlinsuitmedia.model.room.GuestDatabase
import io.reactivex.Maybe
import io.reactivex.Single

class GuestDBRepository(private val application : Context) {
    val con : Context
    init {
        con = application
    }

    fun fetchGuest() :Single<List<GuestProperty>>{
       return GuestDatabase.getGuestDatabase(con).getGuestDao().getGuest()
    }

    fun fetchGuestData() : List<GuestProperty>{
        return GuestDatabase.getGuestDatabase(con).getGuestDao().getGuestData()
    }

    fun insertGuest(Guest : GuestProperty){
        GuestDatabase.getGuestDatabase(con).getGuestDao().insertGuest(Guest)
    }

    fun deleteGuest(){
        GuestDatabase.getGuestDatabase(con).getGuestDao().deleteAll()
    }
}