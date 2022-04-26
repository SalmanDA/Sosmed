package com.fornity.sosmed.network

import com.fornity.sosmed.model.form.Login
import com.fornity.sosmed.model.form.Register
//import com.fornity.sosmed.model.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiCall {
    @POST("login")
    fun postLogin(
        @Body login: Login?
    ): Call<LoginResponse>
    @POST("register")
    fun postRegister(
        @Body register: Register?
    ): Call<LoginResponse>
    @GET("posts")
    fun getposts(
        @Query posts: String?=null
    ): Call<ListResponse>
}