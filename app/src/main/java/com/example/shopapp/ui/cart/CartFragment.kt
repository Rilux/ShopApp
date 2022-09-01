package com.example.shopapp.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopapp.R
import com.example.shopapp.data.local.entities.CartProduct
import com.example.shopapp.databinding.FragmentCartBinding
import com.example.shopapp.ui.sharedViewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var binding: FragmentCartBinding

    private val viewModel: CartFragmentViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var adapter: CartFragmentAdapter
    private lateinit var recyclerview: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater)
        val view = binding.root
        drawRecyclerView()
        lifecycleScope.launch {
            sharedViewModel.getProductInCart()
        }
        sharedViewModel.productsInCart.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
        })
        return view
    }


    private fun drawRecyclerView() {
        recyclerview = binding.RecyclerViewCart
        adapter =
            CartFragmentAdapter(object : CartFragmentAdapterListener {
                override fun onIncreaseClicked(product: CartProduct) {
                    TODO("Not yet implemented")
                }

                override fun onDecreaseClicked(product: CartProduct) {
                    TODO("Not yet implemented")
                }

                override fun onProductClicked(product: CartProduct) {
                    TODO("Not yet implemented")
                }

            })
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(context)
    }
}