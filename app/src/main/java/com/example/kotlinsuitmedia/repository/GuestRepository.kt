package com.example.kotlinsuitmedia.repository

import androidx.lifecycle.LiveData
import com.example.kotlinsuitmedia.network.GuestApiService
import com.example.kotlinsuitmedia.model.GuestProperty
import com.example.kotlinsuitmedia.model.NetworkState
import io.reactivex.disposables.CompositeDisposable

class GuestRepository (private val apiservice: GuestApiService){
    lateinit var guestApiRepository: GuestApiRepository

    fun fetchGuestDetails(compositeDisposable: CompositeDisposable) : LiveData<List<GuestProperty>> {
        guestApiRepository = GuestApiRepository(apiservice,compositeDisposable)
        guestApiRepository.fetchGuest()

        return guestApiRepository.downloadedGuest
    }

    fun getGuestDetailsNetworkState() : LiveData<NetworkState> {
        return guestApiRepository.networkState
    }
}