package com.example.shopapp.repository

import com.example.shopapp.data.local.entities.Category

interface CatalogueCategoriesListRepository {
    suspend fun getCategoriesFromDb(): List<Category>
}