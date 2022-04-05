package com.fornity.sosmed.model.form

import com.google.gson.annotations.SerializedName

data class Login(
    @field:SerializedName("email")
    val email: String? = null,
    @field:SerializedName("password")
    val password: String? = null
)
