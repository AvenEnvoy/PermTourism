package com.bignerdranch.android.permtourism.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.model.User

@Dao
interface Dao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser (user: User)

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPlace (place: Place)

    @Delete
    suspend fun deleteUser (user: User)

    @Delete
    suspend fun deletePlace (place: Place)

    @Query("SELECT * FROM Users ORDER BY id DESC")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM Places ORDER BY id DESC")
    fun getAllPlaces(): LiveData<List<Place>>

    @Query("SELECT * FROM Users WHERE login LIKE :login")
    suspend fun getUser(login: String): User?

    @Query("SELECT * FROM Places WHERE title LIKE :title")
    suspend fun getPlace(title: String): Place?
}