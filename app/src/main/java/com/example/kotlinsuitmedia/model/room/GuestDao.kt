package com.example.kotlinsuitmedia.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinsuitmedia.model.GuestProperty
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface GuestDao {
    @Query("Select * from Guest")
    fun getGuest() : Single<List<GuestProperty>>

    @Query("Select * from Guest")
    fun getGuestData() : List<GuestProperty>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGuest (listGuest : GuestProperty)

    @Query("Delete from Guest")
    fun deleteAll()
}