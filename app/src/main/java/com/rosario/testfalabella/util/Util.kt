package com.rosario.testfalabella.util

import android.util.Log
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
}