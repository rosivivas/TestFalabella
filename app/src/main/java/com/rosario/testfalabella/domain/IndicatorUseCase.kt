package com.rosario.testfalabella.domain

import com.rosario.testfalabella.data.IndicatorApi
import com.rosario.testfalabella.data.model.IndicatorResponse
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IndicatorUseCase @Inject constructor(private val indicatorApi: IndicatorApi){

    fun getIndicators(): Observable<IndicatorResponse> {
        return indicatorApi.getIndicator()
    }
}