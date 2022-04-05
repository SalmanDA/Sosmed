package com.fornity.sosmed.network

import com.fornity.sosmed.model.form.Login
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCall {
    @POST("login")
    fun postLogin(
        @Body login: Login?
    ): Call<LoginResponse>
}