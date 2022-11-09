package com.bignerdranch.android.permtourism.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun addUser (user: User)

    @Query("SELECT * FROM Users ORDER BY id DESC")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM Users WHERE login LIKE :login")
    suspend fun getUser(login: String): User?
}