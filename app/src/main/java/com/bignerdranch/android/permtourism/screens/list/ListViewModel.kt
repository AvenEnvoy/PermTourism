package com.bignerdranch.android.permtourism.screens.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bignerdranch.android.permtourism.REPO
import com.bignerdranch.android.permtourism.db.DataBase
import com.bignerdranch.android.permtourism.db.Repository
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.model.SharedPref

class ListViewModel(application: Application): AndroidViewModel(application) {

    var context = application

    val userName = SharedPref.getName(context)

    fun initDataBase() {
        val db = DataBase.getInstance(context). getDao()
        REPO = Repository(db)
    }

    fun getAllPlaces(): LiveData<List<Place>> {
        return REPO.allPlaces()
    }
}