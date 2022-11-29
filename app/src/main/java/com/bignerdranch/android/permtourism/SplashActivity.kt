package com.bignerdranch.android.permtourism

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.permtourism.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var animation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val options = ActivityOptions.makeSceneTransitionAnimation(this)

        CoroutineScope(Dispatchers.Main).launch {
            animation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.logo)
            binding.ivLogo.startAnimation(animation)
            delay(2000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java), options.toBundle())
        }
    }
}