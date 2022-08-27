package com.example.shopapp.utils.extensions

import com.example.shopapp.data.local.Product
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