package com.bignerdranch.android.permtourism.screens.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.bignerdranch.android.permtourism.model.SharedPref

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val context = application
    val userName = SharedPref.getName(context)
}