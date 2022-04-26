package com.fornity.sosmed.model.form

import com.google.gson.annotations.SerializedName

data class Register (
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("email")
    val email: String? = null,
    @field:SerializedName("password")
    val password: String? = null,
    @field:SerializedName("password_confirmation")
    val passwordconformation: String? = null
)