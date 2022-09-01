package com.example.shopapp.data.repositories

import com.example.shopapp.data.local.dao.ProductDao
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
): CartRepository {
    override suspend fun getProductById(id: Int): Product = productDao.getProductById(id)

}