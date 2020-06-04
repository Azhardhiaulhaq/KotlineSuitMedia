package com.example.kotlinsuitmedia.network

import com.squareup.moshi.Json

data class GuestProperty (
    val id : Int,
    val name : String,
    val birthdate : String
)