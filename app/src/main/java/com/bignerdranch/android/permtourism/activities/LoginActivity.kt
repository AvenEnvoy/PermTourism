package com.bignerdranch.android.permtourism.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.ActivityLoginBinding
import com.bignerdranch.android.permtourism.db.User
import com.bignerdranch.android.permtourism.db.UserDB
import com.bignerdranch.android.permtourism.db.UserDao
import com.bignerdranch.android.permtourism.fragments.RegFragment

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvReg.setOnClickListener() {
            supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.flReg, RegFragment.newInstance())
                .commit()
        }
        // добавление аккаунта администратора
        val db = UserDB.getDB(this)
        val user = User(null, "Admin", "admin@gmail.com", "admin", "admin")
        db.getDao().addUser(user)
    }

    fun onClickSignIp(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}