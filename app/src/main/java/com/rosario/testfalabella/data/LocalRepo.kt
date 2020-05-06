package com.rosario.testfalabella.data

import com.rosario.testfalabella.util.PreferenceManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepo @Inject constructor(var prefManager: PreferenceManager) {

    fun saveUser(){
        prefManager.setUserName("user")
        prefManager.setPassword("clave123")

    }

    fun validateLogin(username: String, password: String) : Boolean{
        return username == prefManager.getUserName() && password == prefManager.getPassword()
    }
}