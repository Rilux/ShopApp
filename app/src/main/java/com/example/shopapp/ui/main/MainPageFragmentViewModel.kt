package com.example.shopapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopapp.data.local.Product
import com.example.shopapp.repository.MainPageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainPageFragmentViewModel @Inject constructor(
    @Named("MainPageRepository") private val repo: MainPageRepository
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