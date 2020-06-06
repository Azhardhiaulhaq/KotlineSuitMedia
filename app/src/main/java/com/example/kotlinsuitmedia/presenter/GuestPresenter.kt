package com.example.kotlinsuitmedia.presenter

import android.content.Context
import com.example.kotlinsuitmedia.model.Guest
import com.example.kotlinsuitmedia.network.APIService
import com.example.kotlinsuitmedia.view.IGuestView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuestPresenter(context : Context) {
    val guest_view = context as IGuestView

    fun getDataFromApi(){
        APIService.create()
            .getGuest()
            .enqueue(object: Callback<List<Guest>> {
                override fun onFailure(call: Call<List<Guest>>, t: Throwable) {
                    guest_view.onDataErrorOnAPI(t)
                }

                override fun onResponse(call: Call<List<Guest>>, response: Response<List<Guest>>) {
                    guest_view.onDataCompletedOnAPI(response.body())
                }

            })
    }
}