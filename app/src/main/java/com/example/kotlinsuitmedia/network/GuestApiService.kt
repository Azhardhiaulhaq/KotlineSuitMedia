package com.example.kotlinsuitmedia.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


private const val BASE_URL = "http://www.mocky.io/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()



interface GuestApiService {
    @GET("596dec7f0f000023032b8017")
    fun getGuest():
            Single<GuestProperty>
}

object GuestApi {
    val retrofitService : GuestApiService by lazy {
        retrofit.create(GuestApiService::class.java)
    }

    fun getGuestData() : GuestApiService {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory( RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GuestApiService::class.java)
    }

}