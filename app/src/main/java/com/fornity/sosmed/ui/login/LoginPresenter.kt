package com.fornity.sosmed.ui.login

import com.fornity.sosmed.model.form.Login
import com.fornity.sosmed.network.ApiCall
import com.fornity.sosmed.network.ApiClient
import com.fornity.sosmed.network.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(private val contract: LoginContract) {
    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)

    fun postLogin(login: Login) {
        client.postLogin(login).enqueue(object:
            Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                when(response.code()){
                    200 -> {
                        if (response.body()?.success ==true){
                            val body: LoginResponse? = response.body()
                            if (body?.data != null) {
                                contract.onLogin(body)
                            }else{
                                contract.onFailed(body!!.message!!)
                            }
                        }else{
                            contract.onFailed(response.body()!!.message!!)
                        }
                    }
                    401->{
                        contract.onFailed(response.body()!!.message!!)
                    }
                    500->{
                        contract.onFailed("Server Error")
                    }
                    else->{
                        contract.onFailed("Unknown Error ${response.message()}")
                    }

                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                contract.onFailed("Unknown Error: $t")
            }
        }

        )

    }
}