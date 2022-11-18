package com.bignerdranch.android.permtourism.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.permtourism.APP
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.adapter.PlaceAdapter
import com.bignerdranch.android.permtourism.databinding.FragmentListBinding
import com.bignerdranch.android.permtourism.databinding.FragmentLoginBinding
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.screens.login.LoginViewModel

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var rv: RecyclerView
    lateinit var adapter: PlaceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.initDataBase()
        rv = binding.rvPlaces
        rv.layoutManager = LinearLayoutManager(viewModel.context,LinearLayoutManager.VERTICAL, false)
        adapter = PlaceAdapter()
        rv.adapter = adapter
        viewModel.getAllPlaces().observe(viewLifecycleOwner, Observer {
            adapter.setList(it.asReversed())
        })
    }

    companion object{
        fun onClickPlace(place: Place) {
            val bundle = Bundle()
            bundle.putSerializable("place", place)
            APP.navController.navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }

}