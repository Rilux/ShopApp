package com.example.shopapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.R
import com.example.shopapp.data.local.Product
import com.example.shopapp.databinding.FragmentMainPageBinding
import com.example.shopapp.ui.sharedViewModels.SharedViewModel
import com.example.shopapp.utils.extensions.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainPageFragment : Fragment(R.layout.fragment_main_page) {
    private lateinit var binding: FragmentMainPageBinding
    val viewModel: MainPageFragmentViewModel by viewModels()
    val sharedViewModel: SharedViewModel by activityViewModels()

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


    private fun drawRecyclerView(){
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.recycler_view_item_width)
        recyclerview = binding.recyclerView
        adapter =  MainPageFragmentAdapter(object : MainPageActionListener {
            override fun onAddToCartClicked(product: Product) {
                sharedViewModel.addProductToTheCart(product)
            }

            override fun onDetailedViewClicked(product: Product) {
                sharedViewModel.setChosenProduct(product)
                findNavController().navigate(R.id.action_rootFragment_to_productDetailedFragment)
            }

        })
        recyclerview.adapter = adapter
        recyclerview.layoutManager = GridLayoutManager(context,2)
        recyclerview.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true, 0))
    }
}