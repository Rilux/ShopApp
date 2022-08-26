package com.example.shopapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.data.model.product.Productslist
import com.example.shopapp.repository.MainPageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainPageFragmentViewModel @Inject constructor(
    @Named("MainPageRepository") private val repo: MainPageRepository
) : ViewModel() {

    private var _productslist = MutableLiveData<Productslist>()
    val productslist: LiveData<Productslist> = _productslist


    suspend fun fetchProducts(number: Int) {
        _productslist.value = repo.getProductsLimited(number).body()
    }

}