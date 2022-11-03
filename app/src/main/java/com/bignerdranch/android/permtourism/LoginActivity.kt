package com.bignerdranch.android.permtourism

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.permtourism.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}