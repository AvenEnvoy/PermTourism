package com.bignerdranch.android.permtourism.model

data class Place(
    val imageId : Int,
    val title : String,
    val description : String,
    val latitude : Double,
    val longitude : Double,
    val favorites : Boolean
)
