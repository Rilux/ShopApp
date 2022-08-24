package com.example.shopapp.data.repositories

import com.example.shopapp.data.model.product.Productslist
import com.example.shopapp.data.remote.ApiService
import com.example.shopapp.repository.MainPageRepository
import retrofit2.Response
import javax.inject.Inject

class MainPageRepositoryImpl @Inject constructor(
    private val api: ApiService
) : MainPageRepository {

    override suspend fun getProductsLimited(number: Int): Response<Productslist> {
        return api.getLimitedAmountOfProducts(number.toString())
    }

}