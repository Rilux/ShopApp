package com.example.shopapp.repository

import com.example.shopapp.data.model.product.Productslist
import retrofit2.Response

interface MainPageRepository {
    suspend fun getProductsLimited(number: Int): Response<Productslist>
}