package com.bignerdranch.android.permtourism.adapters

import com.bignerdranch.android.permtourism.db.Place

interface PlaceOnClickListener {
    fun onClick(place: Place)
}