package com.example.shopapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartProduct(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Double,
    val image: String,
    var numberOfProducts: Int
)