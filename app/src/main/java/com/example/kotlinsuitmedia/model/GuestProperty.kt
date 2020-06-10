package com.example.kotlinsuitmedia.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "Guest")
data class GuestProperty (
    @PrimaryKey
    val id : Int,
    val name : String,
    val birthdate : String
)