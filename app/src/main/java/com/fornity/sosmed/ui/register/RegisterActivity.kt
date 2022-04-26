package com.fornity.sosmed.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fornity.sosmed.databinding.ActivityRegisterBinding
import com.fornity.sosmed.model.form.Register
import com.fornity.sosmed.network.LoginResponse
import com.fornity.sosmed.ui.list.ListActivity
import com.fornity.sosmed.ui.login.LoginActivity
import com.fornity.sosmed.util.AppPreference

class RegisterActivity : AppCompatActivity(), RegisterContract{

    lateinit var binding: ActivityRegisterBinding

    lateinit var pref : AppPreference
    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = AppPreference(this)
        presenter = RegisterPresenter(this)

        with(binding){
            btRegister.setOnClickListener {
                var valid = true
                if(etName.text.toString()==""){
                    valid = false
                    etEmail.error="Wajib diisi"
                }
                if(etEmail.text.toString()==""){
                    valid = false
                    etEmail.error="Wajib diisi"
                }
                if(etPassword.text.toString()==""){
                    valid=false
                    etPassword.error="Wajib diisi"
                }
                if(etConfirmPassword.text.toString()==""){
                    valid=false
                    etConfirmPassword.error="Wajib diisi"
                }
                if(etConfirmPassword.text.toString()!=etPassword.text.toString()){
                    valid=false
                    etConfirmPassword.error="Konfirmasi password tidak sesuai"
                }
                if(valid){
                    var data = Register(etName.text.toString(), etEmail.text.toString(), etPassword.text.toString(), etConfirmPassword.text.toString())
                    presenter.postRegister(data)

                }
            }
            tvLogin.setOnClickListener{
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            }
        }
    }

    override fun onRegister(data: LoginResponse) {
        pref.setAuth(data.data?.token.toString())
        val i = Intent(this, ListActivity::class.java)
        startActivity(i)
        finishAffinity()
    }

    override fun onFailed(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
    }
}