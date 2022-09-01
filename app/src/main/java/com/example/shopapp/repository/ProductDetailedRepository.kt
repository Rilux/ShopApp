package com.example.shopapp.repository

import com.example.shopapp.data.local.entities.CartProduct

interface ProductDetailedRepository {
    suspend fun addProductToCart(cartProduct: CartProduct)
    suspend fun getProductInCart(): List<CartProduct>
}