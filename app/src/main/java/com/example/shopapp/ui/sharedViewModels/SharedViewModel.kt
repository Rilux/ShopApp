package com.example.shopapp.ui.sharedViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.local.entities.CartProduct
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.repository.ProductDetailedRepository
import com.example.shopapp.utils.extensions.ToCartProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repo: ProductDetailedRepository
) : ViewModel() {

    private var _chosenProductForDetails = MutableLiveData<Product>()
    val chosenProductForDetails: LiveData<Product> = _chosenProductForDetails


    private var _chosenCategory = MutableLiveData<Category>()
    val chosenCategory: LiveData<Category> = _chosenCategory

    private var _productsInCart = MutableLiveData<List<CartProduct>>()
    val productsInCart: LiveData<List<CartProduct>> = _productsInCart

    fun setChosenProduct(product: Product) {
        _chosenProductForDetails.value = product
    }

    fun setCategory(category: Category) {
        _chosenCategory.value = category
    }

    suspend fun addToCart(product: Product) {
        repo.addProductToCart(product.ToCartProduct())
        _productsInCart.value = repo.getProductInCart()
    }

    suspend fun getProductInCart() {
        _productsInCart.value = repo.getProductInCart()
    }

    fun changeNumberOfProductsInCart(newNumber: Int, id: Int){
        viewModelScope.launch {
            repo.changeNumberOfProducts(newNumber, id)
            _productsInCart.value = repo.getProductInCart()
        }
    }
}
