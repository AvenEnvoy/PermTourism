package com.bignerdranch.android.permtourism.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.permtourism.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}