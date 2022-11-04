package com.bignerdranch.android.permtourism.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.adapters.PlaceAdapter
import com.bignerdranch.android.permtourism.databinding.ActivityMainBinding
import com.bignerdranch.android.permtourism.model.Place

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = PlaceAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
            rvMain.adapter = adapter
            val place = Place(
                R.drawable.kungur,
                "Кунгурская пещера",
                "Одна из самых популярных достопримечательностей Урала. Вместе с Ледяной горой образует историко-природный комплекс регионального значения",
                57.440953609793006,
                57.00587191043038,
                false)
            adapter.addPlace(place)
            }
        }
    }
