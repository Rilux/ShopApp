package com.example.shopapp.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product

data class CategoryWithProducts (
    @Embedded val categoryName: Category,
    @Relation(
        parentColumn = "categoryName",
        entityColumn = "categoryName"
    )
    val products: List<Product>
)