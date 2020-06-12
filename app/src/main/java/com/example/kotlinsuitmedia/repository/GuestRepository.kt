package com.example.kotlinsuitmedia.repository

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinsuitmedia.network.GuestApiService
import com.example.kotlinsuitmedia.model.GuestProperty
import com.example.kotlinsuitmedia.model.NetworkState
import com.example.kotlinsuitmedia.model.room.GuestDao
import com.example.kotlinsuitmedia.model.room.GuestDatabase
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class GuestRepository (private val apiservice: GuestApiService, private val application: Context){
    lateinit var guestApiRepository: GuestApiRepository
    lateinit var guestDBRepository: GuestDBRepository

    var con : Context

    init {
        con = application
    }
    private val _emptyList = MutableLiveData<Boolean>()

    fun fetchGuestDetails(compositeDisposable: CompositeDisposable) : Observable<List<GuestProperty>> {
        guestDBRepository = GuestDBRepository(con)
        guestApiRepository = GuestApiRepository(apiservice,compositeDisposable)

        if(guestDBRepository.fetchGuestData().isEmpty()){
            return guestApiRepository.fetchGuest()
                .subscribeOn(Schedulers.io())
                .doOnSuccess {
                    it.forEach{
                        guestDBRepository.insertGuest(it)
                    }
                }
                .toObservable()
        } else {
            return guestDBRepository.fetchGuest().toObservable()
        }
//        return guestDBRepository.fetchGuest()
//            .subscribeOn(Schedulers.io())
//            .onErrorResumeNext(guestApiRepository.fetchGuest())
//            .doOnSuccess {
//                it.forEach {
//                    guestDBRepository.insertGuest(it)
//                }
//            }
//            .toObservable()
//        var singleObservable : Single<List<GuestProperty>>
//        if (guestDBRepository.fetchGuestData().isEmpty()){
//            singleObservable = guestApiRepository.fetchGuest()
//            singleObservable.subscribeOn(Schedulers.io())
//                .subscribeOn(Schedulers.io())
//                .doOnSuccess{
//                    it.forEach { {
//                        guestDBRepository.insertGuest(it)
//                    } }
//                }
//                .subscribe()
//        } else {
//            guestDBRepository.fetchGuest().toObservable()
//        }
//        return singleObservable.toObservable()
    }


}