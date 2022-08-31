package com.example.shopapp.ui.sharedViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor() : ViewModel() {

    private var _chosenProductForDetails = MutableLiveData<Product>()
    val chosenProductForDetails: LiveData<Product> = _chosenProductForDetails

    private var _productsInCart = MutableLiveData<MutableList<Product>>()
    val productsInCart: LiveData<MutableList<Product>> = _productsInCart

    private var _chosenCategory = MutableLiveData<Category>()
    val chosenCategory: LiveData<Category> = _chosenCategory

    fun setChosenProduct(product: Product) {
        _chosenProductForDetails.value = product
    }

    fun addProductToTheCart(product: Product) {
        if (_productsInCart.value != null) {
            _productsInCart.value?.add(product)
        } else {
            val mutableTemp = mutableListOf<Product>()
            mutableTemp.add(product)
            _productsInCart.value = mutableTemp
        }
    }

    fun deleteProductFromCart(product: Product) {
        _productsInCart.value?.remove(product)
    }

    fun cleanCart() {
        _productsInCart.value?.clear()
    }

    fun setCategory(category: Category) {
        _chosenCategory.value = category
    }
}
