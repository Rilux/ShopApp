package com.example.shopapp.repository

import com.example.shopapp.data.local.entities.Product

interface CartRepository {
    suspend fun getProductById(id: Int): Product
}