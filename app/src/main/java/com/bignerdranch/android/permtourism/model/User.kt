package com.bignerdranch.android.permtourism.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Users")
class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Name")
    var name: String,
    @ColumnInfo(name = "Email")
    var email: String,
    @ColumnInfo(name = "Login")
    var login: String,
    @ColumnInfo(name = "Password")
    var pass: String
)
