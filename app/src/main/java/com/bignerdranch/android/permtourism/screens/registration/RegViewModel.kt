package com.bignerdranch.android.permtourism.screens.registration
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.permtourism.APP
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.REPO
import com.bignerdranch.android.permtourism.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegViewModel(application: Application): AndroidViewModel(application) {

    var context = application
    var user: User? = null

    fun addUser(userData: User){
        viewModelScope.launch(Dispatchers.Main) {
            user = REPO.getUser(userData.login)
            if (user == null) {
                REPO.addUser(User(name = userData.name, email = userData.email, login = userData.login, pass = userData.pass))
                APP.navController.navigate(R.id.action_regFragment_to_loginFragment)
            } else Toast.makeText(context, "login is already use", Toast.LENGTH_SHORT).show()
        }
    }
}