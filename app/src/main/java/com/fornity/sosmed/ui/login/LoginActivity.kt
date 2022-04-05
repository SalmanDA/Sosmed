package com.fornity.sosmed.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.fornity.sosmed.databinding.ActivityLoginBinding
import com.fornity.sosmed.model.form.Login
import com.fornity.sosmed.network.LoginResponse
import com.fornity.sosmed.ui.list.ListActivity
import com.fornity.sosmed.util.AppPreference

class LoginActivity : AppCompatActivity(), LoginContract {
    lateinit var binding:ActivityLoginBinding

    lateinit var pref :AppPreference
    lateinit var presenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = AppPreference(this)
        presenter = LoginPresenter(this)

        with(binding){
            btLogin.setOnClickListener {
                var valid = true
                if(etEmail.text.toString()==""){
                    valid = false
                    etEmail.error="Wajib diisi"
                }
                if(etPassword.text.toString()==""){
                    valid=false
                    etPassword.error="Wajib diisi"
                }
                if(valid){
                    var data = Login(etEmail.text.toString(), etPassword.text.toString())
                    presenter.postLogin(data)

                }
            }
        }
    }

    override fun onLogin(data: LoginResponse) {
        pref.setAuth(data.data?.token.toString())
        val i = Intent(this, ListActivity::class.java)
        startActivity(i)
        finishAffinity()
    }

    override fun onFailed(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}