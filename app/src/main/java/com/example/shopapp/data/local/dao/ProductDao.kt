package com.example.shopapp.data.local.dao

import androidx.room.*
import com.example.shopapp.data.local.entities.Product

@Dao
interface ProductDao {
    @Query("Select * From product")
    suspend fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll( product: Product)

    @Delete
    suspend fun deleteProduct(vararg product: Product)
}