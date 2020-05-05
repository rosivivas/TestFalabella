package com.rosario.testfalabella.di.module

import android.content.Context
import com.rosario.testfalabella.domain.IndicatorUseCase
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
}