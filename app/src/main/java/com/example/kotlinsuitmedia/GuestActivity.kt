package com.example.kotlinsuitmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinsuitmedia.databinding.ActivityGuestBinding
import com.example.kotlinsuitmedia.model.Guest
import com.example.kotlinsuitmedia.presenter.GuestPresenter
import com.example.kotlinsuitmedia.view.IGuestView
import es.dmoral.toasty.Toasty

class GuestActivity : AppCompatActivity(), IGuestView {
    private lateinit var binding: ActivityGuestBinding
    private lateinit var presenter : GuestPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_guest)
        presenter = GuestPresenter(this)
        presenter.getDataFromApi()
    }

    override fun onDataCompletedOnAPI(item: List<Guest>?) {
        Log.d("Data Guest: ","Succes : ${item} ")
        val adapter = GuestAdapter(this,item)
        binding.guestRV.layoutManager = GridLayoutManager(this,2)
        binding.guestRV.adapter = adapter
    }

    override fun onDataErrorOnAPI(throwable: Throwable) {
        Toasty.error(this,"Error ${throwable.localizedMessage}", Toast.LENGTH_SHORT).show()
    }
}