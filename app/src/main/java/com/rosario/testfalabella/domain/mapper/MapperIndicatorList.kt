package com.rosario.testfalabella.domain.mapper

import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.data.model.IndicatorResponse

class MapperIndicatorList : Mapper<IndicatorResponse, ArrayList<Indicator>>() {

    override fun mapFrom(indicatorResponse: IndicatorResponse): ArrayList<Indicator> {

        val itemList: ArrayList<Indicator> = ArrayList()
        itemList.add(indicatorResponse.uf)
        itemList.add(indicatorResponse.ivp)
        itemList.add(indicatorResponse.dolar)
        itemList.add(indicatorResponse.dolar_intercambio)
        itemList.add(indicatorResponse.euro)
        itemList.add(indicatorResponse.ipc)
        itemList.add(indicatorResponse.utm)
        itemList.add(indicatorResponse.imacec)
        itemList.add(indicatorResponse.tpm)
        itemList.add(indicatorResponse.libra_cobre)
        itemList.add(indicatorResponse.tasa_desempleo)
        itemList.add(indicatorResponse.bitcoin)

        return itemList
    }

}