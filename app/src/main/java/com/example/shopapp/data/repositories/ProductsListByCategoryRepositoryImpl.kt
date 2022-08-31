package com.example.shopapp.data.repositories

import com.example.shopapp.data.local.dao.CategoryWithProductsDao
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.data.local.entities.relations.CategoryWithProducts
import com.example.shopapp.repository.ProductsListByCategoryRepository
import javax.inject.Inject

class ProductsListByCategoryRepositoryImpl @Inject constructor(
    private val categoryWithProductsDao: CategoryWithProductsDao
) : ProductsListByCategoryRepository {
    override suspend fun getProductsByCategory(category: Category): List<CategoryWithProducts> {
        return categoryWithProductsDao.getCategoryWithProducts(category.categoryName)
    }

}