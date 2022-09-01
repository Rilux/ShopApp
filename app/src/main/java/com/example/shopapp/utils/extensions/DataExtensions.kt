package com.example.shopapp.utils.extensions

import com.example.shopapp.data.local.entities.CartProduct
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.data.model.product.Productslist
import com.example.shopapp.data.model.product.ProductslistItem

fun ProductslistItem.ToProduct() = Product(
    id,
    title,
    price,
    description,
    category,
    image,
    rating.rate,
    rating.count
)

fun Productslist.ToProductArray(): List<Product> {
    val tempList = mutableListOf<Product>()
    Productslist().forEach {
        tempList.add(it.ToProduct())
    }


    return tempList
}

fun Product.ToCartProduct() = CartProduct(
    id,
    title,
    price,
    image,
    1
)