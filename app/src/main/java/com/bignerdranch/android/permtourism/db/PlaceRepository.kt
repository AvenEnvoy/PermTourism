package com.bignerdranch.android.permtourism.db

import androidx.lifecycle.LiveData
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.model.User

interface PlaceRepository {
    val allUsers: LiveData<List<User>>
    val allPlaces: LiveData<List<Place>>
    suspend fun addUser (user: User, onSuccess:() -> Unit)
    suspend fun addPlace (place: Place, onSuccess:() -> Unit)
    suspend fun deleteUser (user: User, onSuccess:() -> Unit)
    suspend fun deletePlace (place: Place, onSuccess:() -> Unit)
    suspend fun getUser(login: String): User?
    suspend fun getPlace(title: String): Place?
}