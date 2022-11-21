package com.bignerdranch.android.permtourism.screens.registration
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.permtourism.REPO
import com.bignerdranch.android.permtourism.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegViewModel(application: Application): AndroidViewModel(application) {

    var context = application
    var user: User? = null

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.Main) {
            REPO.addUser(user)
        }
    }

    fun getUser(login: String){
        viewModelScope.launch(Dispatchers.Main) {
            user = REPO.getUser(login)
        }
    }
}