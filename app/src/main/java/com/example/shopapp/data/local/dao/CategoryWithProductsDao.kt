package com.example.shopapp.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.data.local.entities.relations.CategoryWithProducts

interface CategoryWithProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct( product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory( category: Category)


    @Query("Select * From product Where categoryName = :categoryName")
    suspend fun getCategoryWithProducts(categoryName: String):List<CategoryWithProducts>
}
