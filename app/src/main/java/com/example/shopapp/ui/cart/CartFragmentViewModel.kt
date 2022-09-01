package com.example.shopapp.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.local.entities.CartProduct
import com.example.shopapp.repository.ProductDetailedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartFragmentViewModel @Inject constructor(
    private val repo: ProductDetailedRepository
) : ViewModel() {

    private var _cartProducts = MutableLiveData<List<CartProduct>>()
    val cartProducts: LiveData<List<CartProduct>> = _cartProducts

    fun getProductsInCart(){
        viewModelScope.launch {
            _cartProducts.value = repo.getProductInCart()
        }
    }
}