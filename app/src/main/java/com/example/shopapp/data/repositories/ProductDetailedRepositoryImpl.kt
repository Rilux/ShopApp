package com.example.shopapp.data.repositories

import com.example.shopapp.data.local.dao.CartProductDao
import com.example.shopapp.data.local.entities.CartProduct
import com.example.shopapp.repository.ProductDetailedRepository
import javax.inject.Inject

class ProductDetailedRepositoryImpl @Inject constructor(
    private val cartProductDao: CartProductDao
) : ProductDetailedRepository {

    override suspend fun addProductToCart(cartProduct: CartProduct) {
        if(cartProductDao.isRowIsExist(cartProduct.id)){
            val temp = cartProductDao.getCartProductById(cartProduct.id)
            temp.numberOfProducts = temp.numberOfProducts + 1
            cartProductDao.updateCartProduct(temp.numberOfProducts, temp.id)
        }else{
            cartProductDao.insertProduct(cartProduct)
        }
    }

    override suspend fun getProductInCart(): List<CartProduct> = cartProductDao.getCartProducts()

    override suspend fun changeNumberOfProducts(number: Int, id: Int) {
        if (number <= 0){
            cartProductDao.deleteCartProductById(id)
        }else{
            cartProductDao.updateCartProduct(number, id)
        }
    }

}