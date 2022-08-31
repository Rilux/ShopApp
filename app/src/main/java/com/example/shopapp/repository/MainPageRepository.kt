package com.example.shopapp.repository

import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.data.model.product.Productslist
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MainPageRepository {
    suspend fun getProductsLimited(): Response<Productslist>
    suspend fun setNumber(numberTemp: Int)
    val flow: Flow<List<Product>>
}