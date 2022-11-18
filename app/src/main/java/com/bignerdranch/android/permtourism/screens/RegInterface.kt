package com.bignerdranch.android.permtourism.screens

import com.bignerdranch.android.permtourism.model.User

interface RegInterface {
    fun dataPass(data: User, login: String, pass: String)
}