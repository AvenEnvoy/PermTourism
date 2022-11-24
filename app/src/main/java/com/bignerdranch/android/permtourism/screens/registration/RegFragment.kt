package com.bignerdranch.android.permtourism.screens.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.databinding.FragmentRegBinding
import com.bignerdranch.android.permtourism.model.User

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
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.app_name)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[RegViewModel::class.java]
        binding.btnReg.setOnClickListener {
            val userData = User(name = binding.etRegName.text.toString(),
                email = binding.etRegEmail.text.toString(),
                login = binding.etRegLogin.text.toString(),
                pass = binding.etRegPass.text.toString())
            viewModel.addUser(userData)
        }
    }
}

