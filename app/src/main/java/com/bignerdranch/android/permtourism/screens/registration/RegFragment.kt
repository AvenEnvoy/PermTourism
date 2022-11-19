package com.bignerdranch.android.permtourism.screens.registration

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.permtourism.APP
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.FragmentRegBinding
import com.bignerdranch.android.permtourism.model.User
import com.bignerdranch.android.permtourism.screens.RegInterface
import com.bignerdranch.android.permtourism.screens.list.ListViewModel

class RegFragment : Fragment() {

    private lateinit var binding: FragmentRegBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentRegBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[RegViewModel::class.java]
        binding.btnReg.setOnClickListener {
            val name = binding.etRegName.text.toString()
            val email = binding.etRegEmail.text.toString()
            val login = binding.etRegLogin.text.toString()
            val pass = binding.etRegPass.text.toString()
            viewModel.addUser(User(name = name, email = email, login = login, pass = pass))
            APP.navController.navigate(R.id.action_regFragment_to_loginFragment)
        }
    }
}

