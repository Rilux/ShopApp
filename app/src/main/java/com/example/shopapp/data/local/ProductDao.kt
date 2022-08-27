package com.example.shopapp.data.local

import androidx.room.*

@Dao
interface ProductDao {
    @Query("Select * From product")
    suspend fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll( product: Product)

    @Delete
    suspend fun deleteProduct(vararg product: Product)
}