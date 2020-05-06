package com.rosario.testfalabella.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.rosario.testfalabella.R
import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.databinding.ActivityDetailBinding
import com.rosario.testfalabella.util.*
import com.rosario.testfalabella.viewModel.DetailViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    private var indicator = Indicator()
    private lateinit var binding: ActivityDetailBinding

    @Inject
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initBinding()
        prepareElements()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun prepareElements() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra(INDICATOR)) {
            indicator = intent.getSerializableExtra(INDICATOR) as Indicator
            viewModel.loadData(indicator)
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
