package com.example.shopapp.ui.productDetailed

import androidx.lifecycle.ViewModel
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.repository.ProductDetailedRepository
import com.example.shopapp.utils.extensions.ToCartProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailedFragmentViewModel @Inject constructor(
    private val repo: ProductDetailedRepository
) : ViewModel() {


}