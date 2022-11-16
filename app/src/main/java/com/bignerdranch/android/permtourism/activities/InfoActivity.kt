package com.bignerdranch.android.permtourism.activities

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.permtourism.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bmp = intent.getByteArrayExtra("image")
        binding.ivPlace.setImageBitmap(BitmapFactory.decodeByteArray(bmp, 0, bmp!!.size))
        binding.tvTitle.text = intent.getStringExtra("title")
        binding.tvDesc.text = intent.getStringExtra("desc")
    }
}