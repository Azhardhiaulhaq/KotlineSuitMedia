package com.example.kotlinsuitmedia.repository

import androidx.lifecycle.LiveData
import com.example.kotlinsuitmedia.network.GuestApiService
import com.example.kotlinsuitmedia.network.GuestProperty
import io.reactivex.disposables.CompositeDisposable

class GuestRepository (private val apiservice: GuestApiService){
    lateinit var guestNetworkDataSource: GuestNetworkDataSource

    fun fetchGuestDetails(compositeDisposable: CompositeDisposable) : LiveData<GuestProperty> {
        guestNetworkDataSource = GuestNetworkDataSource(apiservice,compositeDisposable)
        guestNetworkDataSource.fetchGuest()

        return guestNetworkDataSource.downloadedGuest
    }

    fun getGuestDetailsNetworkState() : LiveData<NetworkState> {
        return guestNetworkDataSource.networkState
    }
}