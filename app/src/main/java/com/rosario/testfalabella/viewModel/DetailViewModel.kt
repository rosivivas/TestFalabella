package com.rosario.testfalabella.viewModel

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.domain.LoginUseCase
import com.rosario.testfalabella.util.Util
import javax.inject.Inject

class DetailViewModel @Inject constructor(var context: Context) : ViewModel() {

    var indicator = MutableLiveData<Indicator>().apply { Indicator() }
    var date = MutableLiveData<String>()
    var value = MutableLiveData<String>()

    fun loadData(indicator: Indicator) {
        this.indicator.value = indicator
        date.postValue(Util().getDateFormat(indicator.fecha))
        value.postValue(Util().loadValue(indicator, context))
    }
}