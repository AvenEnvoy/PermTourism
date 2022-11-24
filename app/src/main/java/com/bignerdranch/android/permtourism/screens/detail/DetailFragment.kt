package com.bignerdranch.android.permtourism.screens.detail

import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.FragmentDetailBinding
import com.bignerdranch.android.permtourism.model.Place

class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentPlace: Place

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        currentPlace = arguments?.getSerializable("place") as Place
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this) [DetailViewModel::class.java]
        val string = getString(R.string.go)
        (activity as AppCompatActivity).supportActionBar?.title = "$string ${viewModel.userName}?"
        val lati = currentPlace.latitude
        val long = currentPlace.longitude
        binding.apply {
            val bmp = BitmapFactory.decodeByteArray(currentPlace.image, 0, currentPlace.image.size)
            ivPlace.setImageBitmap(bmp)
            tvTitle.text = currentPlace.title
            tvDesc.text = currentPlace.description
            tvAddress.text = currentPlace.address
            val schedule = "Время работы: ${currentPlace.schedule}"
            tvSchedule.text = schedule
        }
    }
}