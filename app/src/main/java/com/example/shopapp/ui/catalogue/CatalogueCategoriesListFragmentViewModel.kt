package com.example.shopapp.ui.catalogue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.repository.CatalogueCategoriesListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CatalogueCategoriesListFragmentViewModel @Inject constructor(
    private val repo: CatalogueCategoriesListRepository
) : ViewModel() {
    private var _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories

    suspend fun getCategoriesList(){
        _categories.value = repo.getCategoriesFromDb()
    }

}