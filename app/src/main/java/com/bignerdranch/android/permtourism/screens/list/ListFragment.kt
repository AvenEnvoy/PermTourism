package com.bignerdranch.android.permtourism.screens.list

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.permtourism.APP
import com.bignerdranch.android.permtourism.R
import com.bignerdranch.android.permtourism.adapter.PlaceAdapter
import com.bignerdranch.android.permtourism.databinding.FragmentListBinding
import com.bignerdranch.android.permtourism.model.Place
import com.bignerdranch.android.permtourism.model.SharedPref

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    lateinit var rv: RecyclerView
    private lateinit var adapter: PlaceAdapter

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
        val string = getString(R.string.welcome)
        (activity as AppCompatActivity).supportActionBar?.title = "$string ${viewModel.userName}!"
        viewModel.initDataBase()
        rv = binding.rvPlaces
        rv.layoutManager = LinearLayoutManager(viewModel.context,LinearLayoutManager.VERTICAL, false)
        adapter = PlaceAdapter()
        rv.adapter = adapter
        viewModel.getAllPlaces().observe(viewLifecycleOwner, Observer {
            adapter.setList(it.asReversed())
        })

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.exit -> {
                        APP.navController.navigate(R.id.action_listFragment_to_loginFragment)
                        SharedPref.setName(viewModel.context, "")
                        true
                    } else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    companion object{
        fun onClickPlace(place: Place) {
            val bundle = Bundle()
            bundle.putSerializable("place", place)
            APP.navController.navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }

}