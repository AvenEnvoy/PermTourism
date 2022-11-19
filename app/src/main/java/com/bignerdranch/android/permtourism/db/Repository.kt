package com.bignerdranch.android.permtourism.db

import androidx.lifecycle.LiveData
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.model.User

class Repository(private val dao: Dao) {

    fun allUsers(): LiveData<List<User>> = dao.getAllUsers()
    fun allPlaces(): LiveData<List<Place>> = dao.getAllPlaces()

    suspend fun addUser(user: User) {
        dao.addUser(user)
    }

    suspend fun addPlace(place: Place) {
        dao.addPlace(place)
    }

    suspend fun deleteUser(user: User) {
        dao.deleteUser(user)
    }

    suspend fun deletePlace(place: Place) {
        dao.deletePlace(place)
    }

    suspend fun getUser(login: String): User? {
        return dao.getUser(login)
    }

    suspend fun getPlace(title: String): Place? {
        return dao.getPlace(title)
    }
}