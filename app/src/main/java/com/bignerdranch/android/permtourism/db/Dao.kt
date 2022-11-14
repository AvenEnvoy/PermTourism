package com.bignerdranch.android.permtourism.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    suspend fun addUser (user: User)

    @Insert
    suspend fun addPlace (place: Place)

    @Query("SELECT * FROM Users ORDER BY id DESC")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM Places ORDER BY id DESC")
    fun getAllPlaces(): LiveData<List<Place>>

    @Query("SELECT * FROM Users WHERE login LIKE :login")
    suspend fun getUser(login: String): User?

    @Query("SELECT * FROM Places WHERE title LIKE :title")
    suspend fun getPlace(title: String): Place?
}