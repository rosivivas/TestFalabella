package com.rosario.testfalabella.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val PREF_NAME = "USER_PREFS"
    private var mPref: SharedPreferences? = null
    private val usermameKey = "username_key"
    private val passwordKey = "password_key"
    private val isLoggedKey = "is_logged_key"

    private var pwCliente: String? = null
    var preferences: SecurePreferences? = null

    init {
        mPref = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE)
        preferences = SecurePreferences(context, PREF_NAME, "nvTfEhRQ375YuZj4QDTV", true)
    }

    fun getUserName(): String? {
        return preferences!!.getString(usermameKey)
    }

    fun setUserName(username: String) {
        preferences!!.putString(usermameKey, username)
    }

    fun setPassword(password: String) {
        preferences!!.putString(passwordKey, password)
    }

    fun getPassword(): String? {
        return preferences!!.getString(passwordKey)
    }


    fun setIsLogged(isLogged: Boolean) {
        preferences!!.putString(isLoggedKey, isLogged.toString())
    }

    fun getIsLogged(): Boolean {
        return when {
            preferences!!.getString(isLoggedKey) == "true" -> true
            preferences!!.getString(isLoggedKey) == "false" -> false
            else -> false
        }
    }


}