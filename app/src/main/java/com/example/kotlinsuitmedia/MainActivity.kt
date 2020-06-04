package com.example.kotlinsuitmedia

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.kotlinsuitmedia.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Check Palindrom")
        builder.setMessage(message)
        builder.setPositiveButton("Proceed"
        ) { dialogInterface, i -> dialogInterface.dismiss() }
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