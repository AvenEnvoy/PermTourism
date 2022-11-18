package com.bignerdranch.android.permtourism.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.model.User

@Database (entities = [User::class, Place::class], version = 1, exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract fun getDao(): Dao
    companion object {
        private var database: DataBase ?= null
        @Synchronized
        fun getInstance(context: Context): DataBase {
            return if(database == null) {
                database = Room.databaseBuilder(context.applicationContext, DataBase::class.java, "DataBase")
                    .createFromAsset("database/db.db")
                    .build()
                database as DataBase
            } else {
                database as DataBase
            }
        }
    }
}