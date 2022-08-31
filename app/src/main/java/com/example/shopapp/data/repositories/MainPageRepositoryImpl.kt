package com.example.shopapp.data.repositories

import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.data.local.dao.ProductDao
import com.example.shopapp.data.model.product.Productslist
import com.example.shopapp.data.remote.ApiService
import com.example.shopapp.repository.MainPageRepository
import com.example.shopapp.utils.extensions.ToProduct
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MainPageRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val productDao: ProductDao
) : MainPageRepository {

    private var number = 5

    override suspend fun getProductsLimited(): Response<Productslist> {
        return api.getLimitedAmountOfProducts(number.toString())
    }

    override suspend fun setNumber(numberTemp: Int){
        number = numberTemp
    }

    override val flow: Flow<List<Product>> =
        flow {
            if (productDao.getAllProducts().isNotEmpty()) {
                emit(productDao.getAllProducts())
            }
            val latestProducts = getProductsLimited().body()
            if (latestProducts != null) {
                latestProducts.forEach {
                    productDao.insertAll(it.ToProduct())
                }
                emit(productDao.getAllProducts())
            }
        }
}