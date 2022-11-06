package com.bignerdranch.android.permtourism.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.FragmentRegBinding
import com.bignerdranch.android.permtourism.db.User
import com.bignerdranch.android.permtourism.db.UserDB

class RegFragment : Fragment() {
    private lateinit var binding: FragmentRegBinding
    private val db = activity?.let { UserDB.getDB(it.applicationContext) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentRegBinding.inflate(inflater)
        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance() = RegFragment()
    }

    override fun onStart() {
        super.onStart()
        binding.btnReg.setOnClickListener() {
            val logText = activity?.findViewById<EditText>(R.id.etLogin)
            logText?.setText(binding.etRegLogin.text.toString())
            val passText = activity?.findViewById<EditText>(R.id.etPass)
            passText?.setText(binding.etRegPass.text.toString())
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            val user = User(null,
                binding.etRegName.text.toString(),
                binding.etRegName.text.toString(),
                binding.etRegLogin.text.toString(),
                binding.etRegPass.text.toString())
            Thread {
                db?.getDao()?.addUser(user)
            }.start()
        }
    }

}

