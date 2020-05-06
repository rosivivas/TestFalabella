package com.rosario.testfalabella.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rosario.testfalabella.domain.LoginUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    val statusLogin = MutableLiveData<Boolean>()
    var progressBar = MutableLiveData<Int>().apply { postValue(View.GONE) }

    init {
        loginUseCase.saveUser()
    }

    fun login(username: String, password: String) {
        progresStart()
        statusLogin.value = loginUseCase.validateLogin(username, password)
        hideProgress()
    }


    private fun hideProgress() {
        progressBar.postValue(View.GONE)
    }

    private fun progresStart() {
        progressBar.postValue(View.VISIBLE)
    }


}