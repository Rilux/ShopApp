package com.example.shopapp.data.model.product


import com.google.gson.annotations.SerializedName

data class ProductslistItem(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)