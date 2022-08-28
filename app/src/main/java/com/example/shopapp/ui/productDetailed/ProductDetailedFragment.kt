package com.example.shopapp.ui.productDetailed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.shopapp.R
import com.example.shopapp.data.local.Product
import com.example.shopapp.databinding.FragmentProductDetailedBinding
import com.example.shopapp.ui.sharedViewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailedFragment : Fragment(R.layout.fragment_product_detailed) {

    private lateinit var binding: FragmentProductDetailedBinding
    val viewModel : ProductDetailedFragmentViewModel by viewModels()
    val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailedBinding.inflate(layoutInflater)
        val view = binding.root

/*        sharedViewModel.chosenProductForDetails.observe(viewLifecycleOwner, Observer {
            Log.d("MyLog", it.toString())
        })*/

        return view
    }

    fun draw(product: Product){

    }

}