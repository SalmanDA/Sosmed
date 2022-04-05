package com.fornity.sosmed.ui.login

import com.fornity.sosmed.network.LoginResponse

interface LoginContract {
    fun onLogin( data:LoginResponse)
    fun onFailed(msg:String)
}