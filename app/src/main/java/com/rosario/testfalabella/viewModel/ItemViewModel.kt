package com.rosario.testfalabella.viewModel

import android.content.Intent
import android.view.View
import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.ui.DetailActivity
import com.rosario.testfalabella.util.DOLAR
import com.rosario.testfalabella.util.INDICATOR
import com.rosario.testfalabella.util.PERCENTAGE
import com.rosario.testfalabella.util.PESOS


class ItemViewModel(var indicator: Indicator) {

    var value : String = ""

    init {
        showValue()
    }

    fun showValue() {
        when (indicator.unidad_medida) {
            PESOS -> value = "CLP $ ${indicator.valor}"
            PERCENTAGE -> value = "${indicator.valor}%"
            DOLAR -> value = "USD $ ${indicator.valor}"
        }
    }

    fun clickIndicator(v: View) {
        val intent = Intent(v.context, DetailActivity::class.java)
        intent.putExtra(INDICATOR, indicator)
        v.context.startActivity(intent)
    }
}