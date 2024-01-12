package com.example.kolin2_3.data

import android.content.Context

class PreferenceHelper(context: Context) {
    val preferenceHelper = context.getSharedPreferences("Levi", Context.MODE_PRIVATE)
    var isShovOnBoard: Boolean
        get() {
            return preferenceHelper.getBoolean("KEY", false)
        }
        set(value) {
            preferenceHelper.edit().putBoolean("KEY", value).apply()
        }
}