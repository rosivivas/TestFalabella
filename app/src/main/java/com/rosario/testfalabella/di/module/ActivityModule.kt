package com.rosario.covid19.di.module

import com.rosario.testfalabella.di.module.ViewModelModule
import com.rosario.testfalabella.ui.DetailActivity
import com.rosario.testfalabella.ui.LoginActivity
import com.rosario.testfalabella.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Module to inject Activities
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun bindDetailActivity(): DetailActivity


}