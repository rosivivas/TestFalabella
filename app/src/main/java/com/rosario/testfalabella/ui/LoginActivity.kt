package com.rosario.testfalabella.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.rosario.testfalabella.R
import com.rosario.testfalabella.databinding.ActivityLoginBinding
import com.rosario.testfalabella.util.PreferenceManager
import com.rosario.testfalabella.viewModel.LoginViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initBinding()
        prepareElements()
        viewModelObserver()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun prepareElements() {
        bt_login.setOnClickListener(this)
    }

    private fun viewModelObserver() {
        viewModel.statusLogin.observe(this, Observer { status ->
            if (status) {
                PreferenceManager(this).setIsLogged(true)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else
                Toast.makeText(
                    this, resources.getText(R.string.invalid_credentials), Toast.LENGTH_SHORT
                ).show()
        })
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_login -> {
                if (validateFields())
                    viewModel.login(
                        username_value.text.toString(),
                        password_value.text.toString()
                    )
            }
        }
    }

    private fun validateFields(): Boolean {
        password_layout.error = null
        username_layout.error = null

        if (username_value.text.toString().isEmpty()) {
            username_layout.error = this.resources.getString(R.string.empty_field)
            return false
        }

        if (password_value.text.toString().isEmpty()) {
            password_layout.error = this.resources.getString(R.string.empty_field)
            return false
        }

        return true
    }
}
