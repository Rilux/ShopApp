package com.example.shopapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.repository.MainPageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainPageFragmentViewModel @Inject constructor(
    private val repo: MainPageRepository
) : ViewModel() {

    private var _productslist = MutableLiveData<List<Product>>()
    val productslist: LiveData<List<Product>> = _productslist


    suspend fun fetchProducts(number: Int) {
        repo.setNumber(number)
        repo.flow.collect {
            _productslist.value = it
        }
    }
}