package com.example.shopapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category (
    @PrimaryKey
    val categoryName: String
)