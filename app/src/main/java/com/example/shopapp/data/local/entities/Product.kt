package com.example.shopapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val categoryName: String,
    val image: String,
    val rating: Double,
    val ratingCount: Int
)