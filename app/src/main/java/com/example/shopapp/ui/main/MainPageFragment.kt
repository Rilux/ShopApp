package com.example.shopapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentMainPageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainPageFragment : Fragment(R.layout.fragment_main_page) {
    private lateinit var binding: FragmentMainPageBinding
    val viewModel: MainPageFragmentViewModel by viewModels()

    private lateinit var adapter: MainPageFragmentAdapter
    private lateinit var recyclerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(layoutInflater)
        val view = binding.root
        drawRecyclerView()
        lifecycleScope.launch {
            viewModel.fetchProducts(30)
        }

        viewModel.productslist.observe(viewLifecycleOwner, Observer{
            Log.d("MyLog", "done ")
            adapter.setList(it)
        })

        return view
    }


    fun drawRecyclerView(){
        recyclerview = binding.recyclerView
        adapter =  MainPageFragmentAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = GridLayoutManager(context,2)
    }
}