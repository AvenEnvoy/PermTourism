package com.bignerdranch.android.permtourism.activities

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.permtourism.adapters.PlaceAdapter
import com.bignerdranch.android.permtourism.adapters.PlaceOnClickListener
import com.bignerdranch.android.permtourism.databinding.ActivityMainBinding
import com.bignerdranch.android.permtourism.data.Arrays
import com.bignerdranch.android.permtourism.db.DataBase
import com.bignerdranch.android.permtourism.db.Place
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

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
            val db = DataBase.getDB(this@MainActivity)
            val data : LiveData<List<Place>> = db.getDao().getAllPlaces()
            data.observe(this@MainActivity, Observer {
                for (i in it.indices) adapter.addPlace(it[i])
                })
        }
    }

    override fun onClick(place: Place) {
        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra("image", place.image)
        intent.putExtra("title", place.title)
        intent.putExtra("desc", place.description)
        startActivity(intent)
    }
}
