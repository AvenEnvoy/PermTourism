package com.bignerdranch.android.permtourism.screens.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.permtourism.REPO
import com.bignerdranch.android.permtourism.db.DataBase
import com.bignerdranch.android.permtourism.db.Repository
import com.bignerdranch.android.permtourism.model.User
import kotlinx.coroutines.*
import kotlin.math.log

class LoginViewModel(application: Application): AndroidViewModel(application) {

    var context = application
    var user: User? = null
    var userPass: String? = null

    fun initDataBase() {
        val db = DataBase.getInstance(context).getDao()
        REPO = Repository(db)
    }

    fun getUser(login: String) {
        viewModelScope.launch(Dispatchers.IO) {
            user = REPO.getUser(login)
            userPass = user?.pass
        }
    }
}
