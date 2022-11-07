package com.bignerdranch.android.permtourism.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.permtourism.databinding.FragmentRegBinding
import com.bignerdranch.android.permtourism.db.User

class RegFragment : Fragment() {
    private lateinit var binding: FragmentRegBinding
    private lateinit var dataPasser: RegInterface
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as RegInterface
    }

    override fun onStart() {
        super.onStart()
        binding.btnReg.setOnClickListener() {
            val user = User(null,
                binding.etRegName.text.toString(),
                binding.etRegName.text.toString(),
                binding.etRegLogin.text.toString(),
                binding.etRegPass.text.toString())
            dataPasser.dataPass(user, binding.etRegLogin.text.toString(), binding.etRegPass.text.toString())
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
    }
}

