package com.example.kotlinsuitmedia.view

interface iLoginView {
    fun onLoginResult(name:String,message:String)
    fun sendName(name:String,messagePalindrom:String)
}