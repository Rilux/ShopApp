package com.example.shopapp.data.repositories

import com.example.shopapp.data.local.dao.CategoryWithProductsDao
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.repository.CatalogueCategoriesListRepository
import javax.inject.Inject

class CatalogueCategoriesListRepositoryImpl @Inject constructor(
    private val categoryWithProductsDao: CategoryWithProductsDao
) : CatalogueCategoriesListRepository {
    override suspend fun getCategoriesFromDb(): List<Category> = categoryWithProductsDao.getCategory()
}