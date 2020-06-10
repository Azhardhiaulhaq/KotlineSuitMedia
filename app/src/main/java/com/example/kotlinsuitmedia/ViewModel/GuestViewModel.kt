package com.example.kotlinsuitmedia.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinsuitmedia.model.GuestProperty
import com.example.kotlinsuitmedia.repository.GuestRepository
import com.example.kotlinsuitmedia.model.NetworkState
import io.reactivex.disposables.CompositeDisposable

class GuestViewModel (private val guestRepository: GuestRepository): ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    val guestDetails : LiveData<List<GuestProperty>> by lazy {
        guestRepository.fetchGuestDetails(compositeDisposable)
    }

    val networkState : LiveData<NetworkState> by lazy {
        guestRepository.getGuestDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}