package com.bignerdranch.android.permtourism.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    fun addUser (user: User)
    @Query("SELECT * FROM Users")
    fun getAllUsers(): Flow<List<User>>
}