package com.example.shopapp.ui.catalogue.productListByCategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.repository.MainPageRepository
import com.example.shopapp.repository.ProductsListByCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListByCategoryFragmentViewModel @Inject constructor(
    private val repo: ProductsListByCategoryRepository
): ViewModel() {

    private var _productslist = MutableLiveData<List<Product>>()
    val productslist: LiveData<List<Product>> = _productslist

    suspend fun getProductsByCategory(category: Category){
        _productslist.value = repo.getProductsByCategory(category)[0].products
    }
}