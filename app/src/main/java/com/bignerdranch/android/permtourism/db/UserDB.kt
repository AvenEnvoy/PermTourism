package com.bignerdranch.android.permtourism.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [User::class], version = 1)
abstract class UserDB: RoomDatabase() {
    abstract fun getDao(): UserDao
    companion object {
        fun getDB(context: Context): UserDB {
            return Room.databaseBuilder(context.applicationContext, UserDB::class.java, "UserDB").build()
        }
    }
}