package com.example.kotlinsuitmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinsuitmedia.ViewModel.GuestViewModel
import com.example.kotlinsuitmedia.databinding.ActivityGuestBinding
import com.example.kotlinsuitmedia.databinding.ActivitySelectEventAndGuestBinding
import com.example.kotlinsuitmedia.network.GuestApi
import com.example.kotlinsuitmedia.network.GuestApiService
import com.example.kotlinsuitmedia.network.GuestProperty
import com.example.kotlinsuitmedia.repository.GuestRepository
import java.io.Console
import java.lang.Math.log

class GuestActivity : AppCompatActivity() {
    private lateinit var viewModel : GuestViewModel
    private lateinit var binding: ActivityGuestBinding
    private lateinit var guestRepository: GuestRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_guest)
//        viewModel = ViewModelProviders.of(this).get(GuestViewModel::class.java)
//
//
//        val dataObserver = Observer<List<GuestProperty>> {new_list ->
//            var listData : List<GuestProperty> = new_list
//            Log.d("Data","Succes : ${listData} ")
//            val adapter = GuestAdapter(this)
//            binding.guestRV.adapter = adapter
//            binding.guestRV.layoutManager = GridLayoutManager(this,2)
//            adapter.data = listData
//        }
//
//        viewModel.guestData.observe(this,dataObserver)
        val apiService : GuestApiService = GuestApi.getGuestData()
        guestRepository = GuestRepository(apiService)
        viewModel = getViewModel()
        viewModel.guestDetails.observe(this,Observer{
            val adapter = GuestAdapter(this)
            binding.guestRV.adapter = adapter
            binding.guestRV.layoutManager = GridLayoutManager(this,2)
            adapter.data = listOf(it)
        })
    }

    private fun getViewModel() : GuestViewModel {
        return ViewModelProviders.of(this,object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass:Class<T>):T{
                @Suppress("UNCHECKED_CAST")
                return GuestViewModel(guestRepository) as T
            }
        })[GuestViewModel::class.java]
    }

}