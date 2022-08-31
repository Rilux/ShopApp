package com.example.shopapp.ui.productDetailed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.shopapp.R
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.databinding.FragmentProductDetailedBinding
import com.example.shopapp.ui.sharedViewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailedFragment : Fragment(R.layout.fragment_product_detailed) {

    private lateinit var binding: FragmentProductDetailedBinding
    val viewModel: ProductDetailedFragmentViewModel by viewModels()
    val sharedViewModel: SharedViewModel by activityViewModels()
    lateinit var currentProduct: Product

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailedBinding.inflate(layoutInflater)
        val view = binding.root

        sharedViewModel.chosenProductForDetails.observe(viewLifecycleOwner, Observer {
            currentProduct = it
            draw(currentProduct)
        })

        binding.buttonAddToCart.setOnClickListener{
            sharedViewModel.addProductToTheCart(currentProduct)
        }

        return view
    }

    private fun draw(product: Product) {
        Glide.with(binding.imageView)
            .load(product.image)
            .into(binding.imageView)

        binding.textViewTitle.text = product.title
        binding.ratingBar.rating = product.rating.toFloat()
        binding.textViewPrice.text = product.price.toString()
        binding.textViewDescription.text = product.description
    }

}