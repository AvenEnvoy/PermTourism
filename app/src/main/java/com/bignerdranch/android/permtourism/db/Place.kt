package com.bignerdranch.android.permtourism.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Places")
data class Place(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Image")
    val image : Int,
    @ColumnInfo(name = "Title")
    val title : String,
    @ColumnInfo(name = "Description")
    val description : String,
    @ColumnInfo(name = "Latitude")
    val latitude : Double,
    @ColumnInfo(name = "Longitude")
    val longitude : Double,
    @ColumnInfo(name = "Address")
    val address : String,
    @ColumnInfo(name = "Schedule")
    val schedule : String
)
