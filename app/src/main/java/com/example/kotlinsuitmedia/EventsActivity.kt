package com.example.kotlinsuitmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinsuitmedia.ViewModel.EventsViewModel
import com.example.kotlinsuitmedia.databinding.ActivityEventsBinding
import com.example.kotlinsuitmedia.model.EventsProperty

class EventsActivity : AppCompatActivity() {
    private lateinit var viewModel : EventsViewModel
    private lateinit var binding: ActivityEventsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_events)
        viewModel = ViewModelProviders.of(this).get(EventsViewModel::class.java)

        val dataObserver = Observer<List<EventsProperty>> { new_list ->
            var listData : List<EventsProperty> = new_list
            Log.d("Data","Succes : ${listData} ")
            val adapter = EventsAdapter(this)
            binding.eventRV.adapter = adapter
            binding.eventRV.layoutManager = GridLayoutManager(this,1)
            adapter.data = listData
        }

        viewModel.eventsData.observe(this,dataObserver)
    }

}