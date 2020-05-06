package com.rosario.testfalabella.viewModel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.data.model.IndicatorResponse
import com.rosario.testfalabella.domain.IndicatorUseCase
import com.rosario.testfalabella.domain.mapper.MapperIndicatorList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainViewModel @Inject constructor(
    private val indicatorUseCase: IndicatorUseCase,
    private val context: Context
) {
    val listData = MutableLiveData<ArrayList<Indicator>>()
    private lateinit var subscription: Disposable
    var progressBar = MutableLiveData<Int>().apply { postValue(View.GONE) }
    var error = MutableLiveData<Throwable>()
    var listIndicator = ArrayList<Indicator>()
    var searchList = ArrayList<Indicator>()

    init {
        getIndicatorList()
    }

    private fun getIndicatorList() {
        subscription = indicatorUseCase.getIndicators()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { progressStart() }
            .doOnTerminate { hideProgress() }
            .subscribe({ result -> registerSuccess(result) },
                { error -> onError(error) })
    }

    private fun hideProgress() {
        progressBar.postValue(View.GONE)
    }

    private fun progressStart() {
        progressBar.postValue(View.VISIBLE)
    }

    private fun registerSuccess(result: IndicatorResponse?) {
        searchList = MapperIndicatorList().mapFrom(result!!)
        listData.value = MapperIndicatorList().mapFrom(result!!)
    }

    private fun onError(result: Throwable) {
        error.value = result
    }

    fun filter(query: String) {
        var search = query
        search = search.toLowerCase(Locale.getDefault())
        listIndicator.clear()
        if (search.isEmpty()) {
            listIndicator.addAll(searchList)
        } else {
            for (indicator in searchList) {
                if (indicator.codigo.toLowerCase(Locale.getDefault()).contains(search)) {
                    listIndicator.add(indicator)
                }
            }
        }
       listData.value = listIndicator
    }

}