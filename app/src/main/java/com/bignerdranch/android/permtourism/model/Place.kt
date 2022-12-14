package com.bignerdranch.android.permtourism.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "Places")
class Place(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Image", typeAffinity = ColumnInfo.BLOB)
    val image : ByteArray,
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
) : Serializable
