package com.example.kotlinsuitmedia.model

import com.google.gson.annotations.SerializedName

data class Guest (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("birthdate") val birthdate : String
)