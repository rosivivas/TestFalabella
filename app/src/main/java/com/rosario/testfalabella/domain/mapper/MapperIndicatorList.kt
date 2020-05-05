package com.rosario.testfalabella.domain.mapper

import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.data.model.IndicatorResponse

class MapperIndicatorList : Mapper<IndicatorResponse, ArrayList<Indicator>>() {

    override fun mapFrom(from: IndicatorResponse): ArrayList<Indicator> {

        val itemList: ArrayList<Indicator> = ArrayList()
        itemList.add(from.uf)
        itemList.add(from.ivp)
        itemList.add(from.dolar)
        itemList.add(from.dolar_intercambio)
        itemList.add(from.euro)
        itemList.add(from.ipc)
        itemList.add(from.utm)
        itemList.add(from.imacec)
        itemList.add(from.tpm)
        itemList.add(from.libra_cobre)
        itemList.add(from.tasa_desempleo)
        itemList.add(from.bitcoin)

        return itemList
    }

}