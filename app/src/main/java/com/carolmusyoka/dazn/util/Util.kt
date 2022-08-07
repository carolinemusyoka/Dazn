package com.carolmusyoka.dazn

import android.content.Context
import androidx.core.os.ConfigurationCompat
import java.text.SimpleDateFormat
import java.util.*

fun String.convertDate(context: Context): String? {

    return try{
        // "2021-11=10T16:24:21.579537Z"
        val currentLocale = ConfigurationCompat.getLocales(context.resources.configuration)[0]
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("GMT")
        val passedDate: Date = inputFormat.parse(this) as Date

        // Form example Mon, Nov *, 2021, 12:10 pm
        val outputFormatDay = SimpleDateFormat("EEE, MMM d, yyyy, hh:mm aaa", currentLocale)
        outputFormatDay.timeZone = TimeZone.getDefault()
        val newDateString = outputFormatDay.format(passedDate)
        newDateString
    } catch(_: Exception){
        "00:00:00"
    }
}