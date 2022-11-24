package com.bignerdranch.android.permtourism

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bignerdranch.android.permtourism.databinding.ActivityMainBinding
import com.bignerdranch.android.permtourism.model.SharedPref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP = this
        navController = Navigation.findNavController(this, R.id.nav_fragment)
        val userName = SharedPref.getName(this)
        if (userName != "") {
            APP.navController.navigate(R.id.listFragment)
        }
    }
}