package com.bignerdranch.android.permtourism.screens.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.permtourism.REPO
import com.bignerdranch.android.permtourism.db.DataBase
import com.bignerdranch.android.permtourism.db.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application) {

    var context = application

    fun initDataBase() {
        val db = DataBase.getInstance(context). getDao()
        REPO = Repository(db)
    }

    fun getUser(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            REPO.getUser(name)
        }
    }
}