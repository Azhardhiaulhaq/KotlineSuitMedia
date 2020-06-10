package com.example.kotlinsuitmedia.repository

import com.example.kotlinsuitmedia.model.GuestProperty
import com.example.kotlinsuitmedia.model.room.GuestDao
import io.reactivex.Single

class GuestDBRepository(private val guestDao: GuestDao) {
    fun getAllGuest() : Single<List<GuestProperty>> {
       return guestDao.getGuest()
    }

    suspend fun insertGuest(listGuest : List<GuestProperty>){
        guestDao.insertGuest(listGuest)
    }
}