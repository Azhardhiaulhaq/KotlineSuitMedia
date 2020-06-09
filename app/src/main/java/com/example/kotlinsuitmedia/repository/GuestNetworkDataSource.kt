package com.example.kotlinsuitmedia.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinsuitmedia.network.GuestApi
import com.example.kotlinsuitmedia.network.GuestApiService
import com.example.kotlinsuitmedia.model.GuestProperty
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GuestNetworkDataSource (private val apiService : GuestApiService, private val compositeDisposable : CompositeDisposable) {

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState : LiveData<NetworkState>
        get() = _networkState

    private val _downloadedGuest = MutableLiveData<List<GuestProperty>>()
    val downloadedGuest : LiveData<List<GuestProperty>>
        get() = _downloadedGuest

    fun fetchGuest(){
        Log.d("Inside","GuestNetworkDataSource Fetch Guest")
        _networkState.postValue(NetworkState.LOADING)
        try{
            compositeDisposable.add(
                GuestApi.getGuestData()
                    .getGuest()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedGuest.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.d("GuestNetworkDataSource",it.message)
                        }
                    )

            )
        } catch(e:Exception){
            Log.d("GuestNetworkDataSource",e.message)
        }
    }
}