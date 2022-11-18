package com.bignerdranch.android.permtourism.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.permtourism.APP
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.FragmentLoginBinding
import com.bignerdranch.android.permtourism.model.User

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        viewModel.initDataBase()
        binding.btnSignIn.setOnClickListener {
            val user = viewModel.getUser(binding.etLogin.text.toString())
            if (user != null) {
                APP.navController.navigate(R.id.action_loginFragment_to_listFragment)
            } else Toast.makeText(viewModel.getApplication(),"error", Toast.LENGTH_SHORT).show()
        }
        binding.tvReg.setOnClickListener {
            APP.navController.navigate(R.id.action_loginFragment_to_regFragment)
        }
    }
}