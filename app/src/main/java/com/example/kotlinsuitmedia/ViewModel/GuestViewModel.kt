package com.example.kotlinsuitmedia.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinsuitmedia.network.GuestApi
import com.example.kotlinsuitmedia.network.GuestProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GuestViewModel : ViewModel(){
    val _response = MutableLiveData<String>()
    val guestData = MutableLiveData<List<GuestProperty>>()

    val response : LiveData<String>
    get() = _response

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getGuestProperties()
    }

    private fun getGuestProperties(){
        coroutineScope.launch{
            var getGuestDeferred = GuestApi.retrofitService.getGuest()
            try {
                var listResult = getGuestDeferred.await()
                _response.value = "Success: ${listResult[0]} Guest properties retrieved"
                guestData.setValue(listResult)
            } catch (e: Exception){
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared(){
        super.onCleared()
        viewModelJob.cancel()
    }

}