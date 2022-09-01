package com.example.shopapp.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.repository.CartRepository
import com.example.shopapp.repository.ProductDetailedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartFragmentViewModel @Inject constructor(
    private val repo: CartRepository
) : ViewModel() {

    private var _cartProducts = MutableLiveData<Product>()
    val cartProducts: LiveData<Product> = _cartProducts

    fun getProductById(id: Int){
        viewModelScope.launch{
            _cartProducts.value = repo.getProductById(id)
        }
    }

}