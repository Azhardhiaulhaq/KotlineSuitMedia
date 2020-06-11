package com.example.kotlinsuitmedia.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinsuitmedia.network.GuestApi
import com.example.kotlinsuitmedia.network.GuestApiService
import com.example.kotlinsuitmedia.model.GuestProperty
import com.example.kotlinsuitmedia.model.NetworkState
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GuestApiRepository (private val apiService : GuestApiService, private val compositeDisposable : CompositeDisposable) {

    fun fetchGuest() : Single<List<GuestProperty>> {
        return GuestApi.getGuestApiService().getGuest()
    }

}