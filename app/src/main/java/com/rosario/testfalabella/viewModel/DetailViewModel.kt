package com.rosario.testfalabella.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.domain.LoginUseCase
import javax.inject.Inject

class DetailViewModel() {

    var indicator = MutableLiveData<Indicator>().apply { Indicator() }

    fun loadData(indicator: Indicator) {
        this.indicator.value = indicator
    }
}