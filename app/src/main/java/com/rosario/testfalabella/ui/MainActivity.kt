package com.rosario.testfalabella.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search_window, menu)

        val myActionMenuItem: MenuItem = menu!!.findItem(R.id.search_window)
        val searchView: SearchView = myActionMenuItem.actionView as SearchView


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                mainViewModel.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                mainViewModel.filter(newText)
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            R.id.logout -> {
                showAlertDialog()
            }
        }

        return true
    }

    private fun logout(){
        PreferenceManager(this).setIsLogged(false)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showAlertDialog(){
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle(resources.getString(R.string.logout))
        builder.setMessage(resources.getString(R.string.logout_message))
        builder.setPositiveButton(resources.getString(R.string.yes)){_, _ ->
            logout()
        }
        builder.setNegativeButton(resources.getString(R.string.no)){_, _ ->
        }

        val dialog: AlertDialog = builder.create()
        // Display the alert dialog on app interface
        dialog.show()
    }

}
