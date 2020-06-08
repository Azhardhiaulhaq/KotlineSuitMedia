package com.example.kotlinsuitmedia.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EventTable")
data class Event (
    @PrimaryKey
    val name : String,
    val date : String,
    val url : String,
    val description : String
)