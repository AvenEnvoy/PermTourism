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

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            REPO.addUser(user)
        }
    }
}