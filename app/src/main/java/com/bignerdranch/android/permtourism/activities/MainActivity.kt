package com.bignerdranch.android.permtourism.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.permtourism.adapters.PlaceAdapter
import com.bignerdranch.android.permtourism.adapters.PlaceOnClickListener
import com.bignerdranch.android.permtourism.databinding.ActivityMainBinding
import com.bignerdranch.android.permtourism.model.Arrays
import com.bignerdranch.android.permtourism.model.Place

class MainActivity : AppCompatActivity(), PlaceOnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val adapter = PlaceAdapter(this)

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
            for (i in 0.. 6) {
                val place = Place(
                    Arrays().imageId[i],
                    Arrays().title[i],
                    Arrays().description[i],
                    Arrays().latitude[i],
                    Arrays().longitude[i],
                    Arrays().favorites[i]
                )
                adapter.addPlace(place)
            }
        }
    }

    override fun onClick(place: Place) {
        val intent = Intent(this, InfoActivity::class.java)
        startActivity(intent)
    }
}
