package com.rosario.testfalabella.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.rosario.testfalabella.R
import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.util.*
import com.rosario.testfalabella.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    private var indicator = Indicator()

    @Inject
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        prepareElements()
    }

    private fun prepareElements() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra(INDICATOR)) {
            indicator = intent.getSerializableExtra(INDICATOR) as Indicator
            loadData(indicator)
        }
    }

    private fun loadData(indicator: Indicator){
        title_name.text = indicator.nombre
        value_code.text = indicator.codigo
        value_unidad_medida.text = indicator.unidad_medida
        value_date.text = Util().getDateFormat(indicator.fecha)
        loadValue(indicator)
    }

    private fun loadValue(indicator: Indicator) {
        when (indicator.unidad_medida) {
            PESOS -> value_value.text = String.format(resources.getString(R.string.clp), indicator.valor.toString())
            PERCENTAGE -> value_value.text = String.format(resources.getString(R.string.percentage), indicator.valor.toString())
            DOLAR -> value_value.text = String.format(resources.getString(R.string.dolar), indicator.valor.toString())
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return true
    }
}
