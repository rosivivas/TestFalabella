package com.rosario.testfalabella.di.module

import android.content.Context
import com.rosario.testfalabella.domain.IndicatorUseCase
import com.rosario.testfalabella.domain.LoginUseCase
import com.rosario.testfalabella.viewModel.DetailViewModel
import com.rosario.testfalabella.viewModel.LoginViewModel
import com.rosario.testfalabella.viewModel.MainViewModel
import dagger.Module
import dagger.Provides

/**
 * Module to provide view model class
 */
@Module
class ViewModelModule {
    @Provides
    fun homeViewModel(useCase: IndicatorUseCase, context: Context) = MainViewModel(useCase, context)

    @Provides
    fun loginViewModel(useCase: LoginUseCase) = LoginViewModel(useCase)

    @Provides
    fun detailViewModel(context: Context) = DetailViewModel(context)
}