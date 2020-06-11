package com.example.kotlinsuitmedia.network

import android.util.Log
import com.example.kotlinsuitmedia.model.GuestProperty
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "http://www.mocky.io/v2/"




interface GuestApiService {
    @GET("596dec7f0f000023032b8017")
    fun getGuest():
            Single<List<GuestProperty>>
}

object GuestApi {

    fun getGuestApiService() : GuestApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory( RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GuestApiService::class.java)
    }

}