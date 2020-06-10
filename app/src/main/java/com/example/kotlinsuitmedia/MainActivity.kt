package com.example.kotlinsuitmedia

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinsuitmedia.ViewModel.GuestViewModel
import com.example.kotlinsuitmedia.ViewModel.UserViewModel
import com.example.kotlinsuitmedia.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    public fun sendName(v: View){
        lateinit var message : String
        val name : String = binding.InsertNameET.text.toString()
        if (checkPalindrom(name)){
            message = "is Palindrom"
        }else {
            message = "not Palindrom"
        }

        //Intent
        val sendNameIntent = Intent(this, SelectEventAndGuestActivity::class.java).apply{
            putExtra("username",name)
        }
        //Building Alert Dialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Check Palindrom")
        builder.setMessage(message)
        builder.setPositiveButton("Proceed"
        ) { dialogInterface, i -> startActivity(sendNameIntent) }
        builder.setNegativeButton("Cancel"
        ) { dialogInterface, i -> dialogInterface.dismiss() }
        builder.show()
    }

    private fun checkPalindrom (Sentence : String) : Boolean {
        val low_sentence : String = Sentence.toLowerCase()
        var isPalindrom : Boolean = true
        var i : Int = low_sentence.length-1
        var j : Int = 0
        while (i > j) {
            if(low_sentence.get(i) != low_sentence.get(j)){
                isPalindrom = false
            }
            i--
            j++
        }
        return isPalindrom
    }

}