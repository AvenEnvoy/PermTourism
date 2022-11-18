package com.bignerdranch.android.permtourism.db

import androidx.lifecycle.LiveData
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.model.User

class PlaceRealization(private val dao: Dao): PlaceRepository {
    override val allUsers: LiveData<List<User>>
        get() = dao.getAllUsers()
    override val allPlaces: LiveData<List<Place>>
        get() = dao.getAllPlaces()

    override suspend fun addUser(user: User, onSuccess: () -> Unit) {
        dao.addUser(user)
        onSuccess()
    }

    override suspend fun addPlace(place: Place, onSuccess: () -> Unit) {
        dao.addPlace(place)
        onSuccess()
    }

    override suspend fun deleteUser(user: User, onSuccess: () -> Unit) {
        dao.deleteUser(user)
        onSuccess()
    }

    override suspend fun deletePlace(place: Place, onSuccess: () -> Unit) {
        dao.deletePlace(place)
        onSuccess()
    }

    override suspend fun getUser(login: String): User? {
        return dao.getUser(login)
    }

    override suspend fun getPlace(title: String): Place? {
        return dao.getPlace(title)
    }
}