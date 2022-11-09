package com.bignerdranch.android.permtourism.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.ActivityLoginBinding
import com.bignerdranch.android.permtourism.db.User
import com.bignerdranch.android.permtourism.db.DataBase
import com.bignerdranch.android.permtourism.fragments.RegFragment
import com.bignerdranch.android.permtourism.fragments.RegInterface
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity(), RegInterface {
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
    }

    override fun dataPass(data: User, login: String, pass: String) {
        binding.etLogin.setText(login)
        binding.etPass.setText(pass)
        val db = DataBase.getDB(this)
        CoroutineScope(Dispatchers.IO).launch{
            db.getDao().addUser(data)
        }
    }

    fun onClickSignIn(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}