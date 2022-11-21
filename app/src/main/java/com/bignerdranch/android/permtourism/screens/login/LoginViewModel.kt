package com.bignerdranch.android.permtourism.screens.login

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.permtourism.APP
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.REPO
import com.bignerdranch.android.permtourism.db.DataBase
import com.bignerdranch.android.permtourism.db.Repository
import com.bignerdranch.android.permtourism.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application) {

    var context = application
    var user: User? = null

    fun initDataBase() {
        val db = DataBase.getInstance(context).getDao()
        REPO = Repository(db)
    }

    fun getUser(login: String, pass: String) {
        viewModelScope.launch(Dispatchers.Main) {
            user = REPO.getUser(login)
            val userPass = pass
            if (user != null && userPass == user?.pass) {
                APP.navController.navigate(R.id.action_loginFragment_to_listFragment)
            } else Toast.makeText(context,"unknown user", Toast.LENGTH_SHORT).show()
        }
    }
}
