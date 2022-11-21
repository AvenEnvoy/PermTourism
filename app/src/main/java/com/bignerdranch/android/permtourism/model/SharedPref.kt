package com.bignerdranch.android.permtourism.model

import android.content.Context
import android.content.SharedPreferences

class SharedPref {
    companion object {
        fun setName(context: Context, value: String) {
            val sharedPref: SharedPreferences = context.getSharedPreferences("UserName", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.putString("UserName", value)
            editor.apply()
        }
        fun getName(context: Context): String? {
            val sharedPref: SharedPreferences = context.getSharedPreferences("UserName", Context.MODE_PRIVATE)
            return sharedPref.getString("UserName", "")
        }
    }
}