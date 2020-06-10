package com.example.kotlinsuitmedia.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinsuitmedia.model.GuestProperty
import io.reactivex.Single

@Dao
interface GuestDao {
    @Query("Select * from Guest")
    fun getGuest() : Single<List<GuestProperty>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGuest (listGuest : List<GuestProperty>)

    @Query("Delete from Guest")
    suspend fun deleteAll()
}