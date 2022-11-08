package com.bignerdranch.android.permtourism.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.PlaceItemBinding
import com.bignerdranch.android.permtourism.model.Place

class PlaceAdapter(private val listener: PlaceOnClickListener): RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    private val placeList = ArrayList<Place>()
    class PlaceHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = PlaceItemBinding.bind(item)
        fun bind(place: Place, listener: PlaceOnClickListener) {
            binding.apply {
                ivPlace.setImageResource(place.imageId)
                tvTitle.text = place.title
                tvDesc.text = place.description
                itemView.setOnClickListener {
                    listener.onClick(place)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlaceHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.bind(placeList[position], listener)
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    fun addPlace(place: Place) {
        placeList.add(place)
    }
}