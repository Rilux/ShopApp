package com.example.shopapp.data.local

import androidx.room.*

@Dao
interface ProductDao {
    @Query("Select * From product")
    fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg product: List<Product>)

    @Delete
    fun deleteProduct(vararg product: Product)
}