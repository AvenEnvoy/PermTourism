package com.bignerdranch.android.permtourism.screens.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bignerdranch.android.permtourism.REPO
import com.bignerdranch.android.permtourism.db.DataBase
import com.bignerdranch.android.permtourism.db.PlaceRealization
import com.bignerdranch.android.permtourism.model.Place

class ListViewModel(application: Application): AndroidViewModel(application) {

    var context = application

    fun initDataBase() {
        val db = DataBase.getInstance(context). getDao()
        REPO = PlaceRealization(db)
    }

    fun getAllPlaces(): LiveData<List<Place>> {
        return REPO.allPlaces
    }
}