package com.bignerdranch.android.permtourism.screens.detail

import android.os.Binder
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
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

    }
}