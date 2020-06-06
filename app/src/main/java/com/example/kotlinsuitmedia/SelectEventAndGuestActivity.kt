package com.example.kotlinsuitmedia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kotlinsuitmedia.databinding.ActivitySelectEventAndGuestBinding
import com.example.kotlinsuitmedia.presenter.ISelectEventAndGuestPresenter
import com.example.kotlinsuitmedia.presenter.SelectEventAndGuestPresenter
import com.example.kotlinsuitmedia.view.ISelectEventAndGuestView
import es.dmoral.toasty.Toasty

class SelectEventAndGuestActivity : AppCompatActivity(), ISelectEventAndGuestView {
    private lateinit var binding: ActivitySelectEventAndGuestBinding
    lateinit var presenter : ISelectEventAndGuestPresenter
    private var GET_GUEST : Int = 1
    private var GET_EVENT : Int = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_event_and_guest)
        presenter = SelectEventAndGuestPresenter(this)
        presenter.showName(getIntent())
    }

    fun GuestPicker(v: View){
        val guestIntent = Intent(this, GuestActivity::class.java)
        startActivityForResult(guestIntent,GET_GUEST)
    }

    fun EventPicker(v:View){
        val eventIntent = Intent(this, EventsActivity::class.java)
        startActivityForResult(eventIntent,GET_EVENT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.showResult(requestCode,resultCode,data)
    }

    // View Function
    override fun onPhoneResult(phone: String) {
        Toasty.info(this,phone, Toast.LENGTH_SHORT).show()
    }

    override fun onNameResult(name: String) {
        binding.inputNameTV.setText(name)
    }

    override fun onGetGuestResult(name: String, birthdate: String) {
        binding.guestBtn.text = name
        presenter.showPhone(name,birthdate)
    }

    override fun onGetEventResult(eventname: String) {
        binding.eventBtn.text = eventname
    }
}