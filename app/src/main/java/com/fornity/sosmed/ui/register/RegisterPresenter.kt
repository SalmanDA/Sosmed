package com.fornity.sosmed.ui.register

import com.fornity.sosmed.model.form.Register
import com.fornity.sosmed.network.ApiCall
import com.fornity.sosmed.network.ApiClient
import com.fornity.sosmed.network.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter (private val contract: RegisterContract){

    val client: ApiCall = ApiClient.getClient().create(ApiCall::class.java)

    fun postRegister(register: Register) {
        client.postRegister(register).enqueue(object:
            Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                when(response.code()){
                    201 -> {
                        if (response.body()?.success ==true){
                            val body: LoginResponse? = response.body()
                            if (body?.data != null) {
                                contract.onRegister(body)
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