package com.example.shopapp.data.repositories

import com.example.shopapp.data.local.Product
import com.example.shopapp.data.local.ProductDao
import com.example.shopapp.data.model.product.Productslist
import com.example.shopapp.data.model.product.ProductslistItem
import com.example.shopapp.data.remote.ApiService
import com.example.shopapp.repository.MainPageRepository
import com.example.shopapp.utils.extensions.ToProduct
import com.example.shopapp.utils.extensions.ToProductArray
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response
import javax.inject.Inject

class MainPageRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val productDao: ProductDao
) : MainPageRepository {

    var number = 5

    override suspend fun getProductsLimited(number: Int): Response<Productslist> {
        return api.getLimitedAmountOfProducts(number.toString())
    }

    override suspend fun getData(numberTemp: Int): List<Product>{
        flow.collect{

        }

    }

    val flow: Flow<List<Product>> =
        flow {
            if (productDao.getAllProducts().isNotEmpty()) {
                emit(productDao.getAllProducts())
            }
            val latestProducts = getProductsLimited(number).body()
            if (latestProducts != null) {
                productDao.insertAll(latestProducts.ToProductArray())
                emit(productDao.getAllProducts())
            }
        }
}