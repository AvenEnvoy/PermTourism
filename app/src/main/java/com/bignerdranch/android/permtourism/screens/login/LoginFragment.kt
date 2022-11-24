package com.bignerdranch.android.permtourism.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.permtourism.APP
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.app_name)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        viewModel.initDataBase()
        binding.btnSignIn.setOnClickListener {
            viewModel.getUser(binding.etLogin.text.toString(), binding.etPass.text.toString())
        }
        binding.tvReg.setOnClickListener {
            APP.navController.navigate(R.id.action_loginFragment_to_regFragment)
        }
    }
}