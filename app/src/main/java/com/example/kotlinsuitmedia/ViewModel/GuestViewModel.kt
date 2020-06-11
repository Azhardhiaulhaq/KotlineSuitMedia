package com.example.kotlinsuitmedia.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinsuitmedia.model.GuestProperty
import com.example.kotlinsuitmedia.repository.GuestRepository
import com.example.kotlinsuitmedia.model.NetworkState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GuestViewModel (private val guestRepository: GuestRepository): ViewModel(){

    private val compositeDisposable = CompositeDisposable()

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState : LiveData<NetworkState>
        get() = _networkState

    private val _downloadedGuest = MutableLiveData<List<GuestProperty>>()
    val downloadedGuest : LiveData<List<GuestProperty>>
        get() = _downloadedGuest

    init {
        guestDetails()
    }

    fun guestDetails() {
        _networkState.postValue(NetworkState.LOADING)
        compositeDisposable.add(
            guestRepository.fetchGuestDetails(compositeDisposable)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    _downloadedGuest.postValue(it)
                    _networkState.postValue(NetworkState.LOADED)
                },{
                    _networkState.postValue(NetworkState.ERROR)
                    Log.d("GuestNetworkDataSource", it.message)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}