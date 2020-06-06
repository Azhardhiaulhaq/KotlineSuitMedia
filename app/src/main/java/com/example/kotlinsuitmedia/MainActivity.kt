package com.example.kotlinsuitmedia

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.databinding.DataBindingUtil
import com.example.kotlinsuitmedia.databinding.ActivityMainBinding
import com.example.kotlinsuitmedia.presenter.LoginPresenter
import com.example.kotlinsuitmedia.presenter.iLoginPresenter
import com.example.kotlinsuitmedia.view.iLoginView
import es.dmoral.toasty.Toasty


class MainActivity : AppCompatActivity(), iLoginView {
    private lateinit var binding: ActivityMainBinding
    lateinit var loginPresenter : iLoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loginPresenter = LoginPresenter(this)
    }

    public fun checkName(v: View){
        loginPresenter.onLogin(binding.InsertNameET.text.toString())
    }

    override fun onLoginResult(name:String,message: String) {
        if(message == "Login success"){
            loginPresenter.checkPalindrom(name)
        } else {
            Toasty.error(this,message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun sendName(name: String, messagePalindrom: String) {
        val sendNameIntent = Intent(this, SelectEventAndGuestActivity::class.java).apply{
            putExtra("username",name)
        }
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Check Palindrom")
        builder.setMessage(messagePalindrom)
        builder.setPositiveButton("Proceed"
        ) { dialogInterface, i -> startActivity(sendNameIntent) }
        builder.setNegativeButton("Cancel"
        ) { dialogInterface, i -> dialogInterface.dismiss() }
        builder.show()
    }
}