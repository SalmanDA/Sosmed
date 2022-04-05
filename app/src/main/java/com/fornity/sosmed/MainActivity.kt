package com.fornity.sosmed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fornity.sosmed.ui.list.ListActivity
import com.fornity.sosmed.ui.login.LoginActivity
import com.fornity.sosmed.util.AppPreference

class MainActivity : AppCompatActivity() {
    lateinit var preference: AppPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preference = AppPreference(this)

        if(preference.getAuth()!=""){
            val i = Intent(this, ListActivity::class.java)
            startActivity(i)
            finish()
        }else{
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}