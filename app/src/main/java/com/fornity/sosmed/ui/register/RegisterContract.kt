package com.fornity.sosmed.ui.register

import com.fornity.sosmed.network.LoginResponse

interface RegisterContract {
    fun onRegister( data: LoginResponse)
    fun onFailed(msg:String)
}