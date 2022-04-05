package com.fornity.sosmed.util

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.fornity.sosmed.R

class AppPreference
    (val context: Context) {
    private var prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    //////////////////////////////////////
    fun setAuth(input: String) {
        val editor = this.prefs.edit()
        val key = context.resources.getString(R.string.auth)
        editor.putString(key, "$input")
        editor.apply()
    }
    fun getAuth(): String {
        val key = context.resources.getString(R.string.auth)
        return prefs.getString(key, "").toString()
        //return getUser().jwt?:""
    }
}