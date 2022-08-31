package com.example.shopapp.repository

import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.data.local.entities.relations.CategoryWithProducts

interface ProductsListByCategoryRepository {
    suspend fun getProductsByCategory(category: Category): List<CategoryWithProducts>
}