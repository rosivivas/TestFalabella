package com.rosario.testfalabella.util

import android.content.Context
import android.util.Log
import com.rosario.testfalabella.R
import retrofit2.adapter.rxjava2.HttpException
import java.text.SimpleDateFormat

class Util {

    fun getDateFormat(date: String): String {
        try {
            var spfInput = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val newDate = spfInput.parse(date)
            var spfOutput = SimpleDateFormat("dd/MM/yyyy")
            return spfOutput.format(newDate)
        } catch (e: Exception) {
            Log.e("Error", "error: " + e.message)
        }
        return ""
    }


    fun handleError(it: Throwable?, context: Context): String? {
        return if (it is HttpException)
            when {
                it.code() == 500 -> return context.resources.getString(R.string.error_500)
                it.code() == 401 -> return context.resources.getString(R.string.error_401)
                else -> context.resources.getString(R.string.error)
            }
        else
            return context.resources.getString(R.string.error)

    }
}