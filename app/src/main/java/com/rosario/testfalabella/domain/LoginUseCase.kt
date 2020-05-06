package com.rosario.testfalabella.domain

import com.rosario.testfalabella.data.LocalRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase @Inject constructor(private var localRepo: LocalRepo) {

    fun saveUser() {
        localRepo.saveUser()
    }

    fun validateLogin(username: String, password: String): Boolean {
        return localRepo.validateLogin(username, password)
    }

   // val localRepo = LocalRepo()

  //  fun getIndicators(): Observable<IndicatorResponse> {
       // return localRepo.getIndicator()
   // }
}