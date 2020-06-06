package com.example.kotlinsuitmedia.network

import com.example.kotlinsuitmedia.model.Guest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://www.mocky.io/v2/"

interface APIService {
    @GET("596dec7f0f000023032b8017")
    fun getGuest() : Call<List<Guest>>

    companion object {
        fun create() : APIService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(APIService::class.java)
        }
    }
}