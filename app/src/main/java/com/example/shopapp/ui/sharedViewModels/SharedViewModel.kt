package com.example.shopapp.ui.sharedViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.repository.ProductDetailedRepository
import com.example.shopapp.utils.extensions.ToCartProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repo: ProductDetailedRepository
) : ViewModel() {

    private var _chosenProductForDetails = MutableLiveData<Product>()
    val chosenProductForDetails: LiveData<Product> = _chosenProductForDetails


    private var _chosenCategory = MutableLiveData<Category>()
    val chosenCategory: LiveData<Category> = _chosenCategory

    fun setChosenProduct(product: Product) {
        _chosenProductForDetails.value = product
    }

    fun setCategory(category: Category) {
        _chosenCategory.value = category
    }

    suspend fun addToCart(product: Product){
        repo.addProductToCart(product.ToCartProduct())
    }
}
