package com.rosario.testfalabella.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rosario.testfalabella.R
import com.rosario.testfalabella.databinding.ActivityMainBinding
import com.rosario.testfalabella.util.PreferenceManager
import com.rosario.testfalabella.viewModel.MainViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var mainViewModel: MainViewModel
    private val adapter = IndicatorAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initBinding()
        prepareElements()
        viewModelObserver()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
    }

    private fun prepareElements() {
        tv_title.text = resources.getString(R.string.title, PreferenceManager(this).getUserName())

        binding.rvIndicators.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvIndicators.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        binding.rvIndicators.adapter = adapter

    }

    private fun viewModelObserver(){
        mainViewModel.listData.observe(this, Observer {
            adapter.updateList(it)
        })
    }


}
