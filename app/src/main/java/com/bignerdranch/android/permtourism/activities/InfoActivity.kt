package com.bignerdranch.android.permtourism.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivPlace.setImageResource(intent.getIntExtra("image", R.drawable.gorod))
        binding.tvTitle.text = intent.getStringExtra("title")
        binding.tvDesc.text = intent.getStringExtra("desc")
    }
}