package com.example.kotlinsuitmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinsuitmedia.databinding.ActivityEventsBinding
import com.example.kotlinsuitmedia.model.Event
import com.example.kotlinsuitmedia.presenter.EventPresenter
import com.example.kotlinsuitmedia.view.IEventView

class EventsActivity : AppCompatActivity(), IEventView {
    private lateinit var binding: ActivityEventsBinding
    val presenter = EventPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_events)
        presenter.addData()
        presenter.getData()
    }

    override fun onDataCompleted(item: List<Event>) {
        val adapter = EventsAdapter(this,item)
        binding.eventRV.adapter = adapter
        binding.eventRV.layoutManager = GridLayoutManager(this,1)
    }

}