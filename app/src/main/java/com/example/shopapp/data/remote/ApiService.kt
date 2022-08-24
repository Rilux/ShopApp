package com.example.shopapp.data.remote

import com.example.shopapp.data.model.product.Productslist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://fakestoreapi.com/products?limit=5
    @GET("products")
    suspend fun getLimitedAmountOfProducts(
        @Query("limit") limit: String
    ): Response<Productslist>

}