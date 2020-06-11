package com.example.kotlinsuitmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinsuitmedia.ViewModel.GuestViewModel
import com.example.kotlinsuitmedia.databinding.ActivityGuestBinding
import com.example.kotlinsuitmedia.network.GuestApi
import com.example.kotlinsuitmedia.network.GuestApiService
import com.example.kotlinsuitmedia.repository.GuestRepository

class GuestActivity : AppCompatActivity() {
    private lateinit var viewModel : GuestViewModel
    private lateinit var binding: ActivityGuestBinding
    private lateinit var guestRepository: GuestRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_guest)
        guestRepository = GuestRepository(GuestApi.getGuestApiService(),this)
        viewModel = getViewModel()
        viewModel.downloadedGuest.observe(this,Observer{
            Log.d("Check DownloadedGuest", it.toString())
            val adapter = GuestAdapter(this)
            binding.guestRV.adapter = adapter
            binding.guestRV.layoutManager = GridLayoutManager(this,2)
            adapter.data = it
        })
        viewModel.networkState.observe(this,Observer{
            if(it.msg == "Running" ){
                binding.spinKit.visibility = View.VISIBLE
            } else if (it.msg == "Success"){
                binding.spinKit.visibility = View.GONE
            }
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