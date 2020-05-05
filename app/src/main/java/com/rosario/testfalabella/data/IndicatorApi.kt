package com.rosario.testfalabella.data

import com.rosario.testfalabella.data.model.IndicatorResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Contain specific URL
 */
interface IndicatorApi {
    @GET("api")
    fun getIndicator(): Observable<IndicatorResponse>

}