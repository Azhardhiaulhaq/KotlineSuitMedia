package com.example.kotlinsuitmedia.presenter

import com.example.kotlinsuitmedia.model.User
import com.example.kotlinsuitmedia.view.iLoginView

class LoginPresenter (internal var iLoginView: iLoginView) : iLoginPresenter {
    override fun onLogin(name: String) {
        val user = User(name)
        val isLoginSuccess = user.isDataValid
        if(isLoginSuccess){
            iLoginView.onLoginResult(name,"Login success")
        } else {
            iLoginView.onLoginResult(name,  "Login error")
        }
    }

    override fun checkPalindrom(name: String) {
        val low_sentence : String = name.toLowerCase()
        var messagePalindrom : String = "is Palindrom"
        var i : Int = low_sentence.length-1
        var j : Int = 0
        while (i > j) {
            if(low_sentence.get(i) != low_sentence.get(j)){
                messagePalindrom = "not Palindrom"
            }
            i--
            j++
        }
        iLoginView.sendName(name,messagePalindrom)
    }

}