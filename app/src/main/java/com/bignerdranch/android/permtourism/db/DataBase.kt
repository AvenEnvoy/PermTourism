package com.bignerdranch.android.permtourism.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [User::class, Place::class], version = 1, exportSchema = true)
abstract class DataBase: RoomDatabase() {
    abstract fun getDao(): Dao
    companion object {
        fun getDB(context: Context): DataBase {
            return Room.databaseBuilder(context.applicationContext, DataBase::class.java, "DataBase")
                .createFromAsset("database/db.db")
                .build()
        }
    }
}