package com.example.shopapp.ui.catalogue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.databinding.FragmentCatalogueCategoriesListBinding

class CatalogueCategoriesListFragment : Fragment() {

    lateinit var binding: FragmentCatalogueCategoriesListBinding

    private lateinit var adapter: CatalogueCategoriesListFragmentAdapter
    private lateinit var recyclerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogueCategoriesListBinding.inflate(layoutInflater)
        val view = binding.root
        setRecycler()

        //adapter.setList()


        return view
    }

    fun setRecycler(){
        recyclerview = binding.recyclerView
        adapter =  CatalogueCategoriesListFragmentAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(context)
    }
}