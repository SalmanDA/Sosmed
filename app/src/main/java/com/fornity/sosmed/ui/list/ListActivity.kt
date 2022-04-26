package com.fornity.sosmed.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fornity.sosmed.R
import com.fornity.sosmed.databinding.ActivityListBinding
import com.fornity.sosmed.ui.login.LoginActivity
import com.fornity.sosmed.util.AppPreference

class ListActivity : AppCompatActivity() {
    lateinit var binding: ActivityListBinding
    lateinit var preference: AppPreference
//    private lateinit var listView ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preference = AppPreference(this)




        binding.btLogout.setOnClickListener {
            preference.setAuth("")
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finishAffinity()
        }
    }
}