package com.example.shopapp.data.local.dao

import androidx.room.*
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product
import com.example.shopapp.data.local.entities.relations.CategoryWithProducts

@Dao
interface CategoryWithProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Transaction
    @Query("Select * From product Where categoryName = :categoryName")
    suspend fun getCategoryWithProducts(categoryName: String): List<CategoryWithProducts>

    @Query("Select * From category")
    suspend fun getCategory(): List<Category>
}
