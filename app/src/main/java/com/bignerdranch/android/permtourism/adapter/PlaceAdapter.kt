package com.bignerdranch.android.permtourism.adapter

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.permtourism.APP
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.PlaceItemBinding
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.screens.list.ListFragment

class PlaceAdapter: RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    var placeList: List<Place> = emptyList()

    class PlaceHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = PlaceItemBinding.bind(view)
        fun bind(place: Place) {
            binding.apply {
                val bmp = BitmapFactory.decodeByteArray(place.image, 0, place.image.size)
                ivPlace.setImageBitmap(bmp)
                tvTitle.text = place.title
                tvDesc.text = place.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlaceHolder(view)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.bind(placeList[position])
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Place>) {
        placeList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: PlaceHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            ListFragment.onClickPlace(placeList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: PlaceHolder) {
        holder.itemView.setOnClickListener(null)
    }
}
