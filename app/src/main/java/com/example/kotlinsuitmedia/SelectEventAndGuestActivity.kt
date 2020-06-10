package com.example.kotlinsuitmedia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinsuitmedia.ViewModel.UserViewModel
import com.example.kotlinsuitmedia.databinding.ActivitySelectEventAndGuestBinding
import es.dmoral.toasty.Toasty

class SelectEventAndGuestActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectEventAndGuestBinding
    private lateinit var viewModel : UserViewModel
    private var GET_GUEST : Int = 1
    private var GET_EVENT : Int = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_event_and_guest)

        val nameIntent : Intent = getIntent()
        if (nameIntent.hasExtra("username")){
            binding.inputNameTV.setText(nameIntent.getExtras()?.getString("username"))
        }

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
        if(requestCode == GET_GUEST){
            if(resultCode == RESULT_OK){
                val name : String? = data?.getExtras()?.getString("guestName")
                val birthDate: String? = data?.getExtras()?.getString("guestBirthDate")
                binding.guestBtn.text = name
                val arrBirthDate =
                    birthDate!!.split("-".toRegex(), 3).toTypedArray()
                val date = arrBirthDate[2].toInt()
                var toastString = ""
                toastString = if (date % 2 == 0) {
                    "blackberry"
                } else if (date % 3 == 0) {
                    "android"
                } else if (date % 2 == 0 && date % 3 == 0) {
                    "iOS"
                } else {
                    "feature phone"
                }
                Toasty.info(applicationContext,toastString,Toast.LENGTH_SHORT).show()

            }
        } else if (requestCode == GET_EVENT) {
            if(resultCode == RESULT_OK){
                val eventName : String? = data?.getExtras()?.getString("eventName")
                binding.eventBtn.text = eventName
            }
        }
    }

}