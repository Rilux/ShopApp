package com.example.shopapp.data.local.dao

import androidx.room.*
import com.example.shopapp.data.local.entities.CartProduct

@Dao
interface CartProductDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: CartProduct)

    @Transaction
    @Query("Select * From CartProduct")
    suspend fun getCartProducts(): List<CartProduct>

    @Transaction
    @Query("Select * From CartProduct Where id = :id")
    suspend fun getCartProductById(id: Int): CartProduct

    @Transaction
    @Query("SELECT EXISTS(SELECT * FROM CartProduct WHERE id = :id)")
    suspend fun isRowIsExist(id: Int): Boolean

    @Transaction
    @Query("UPDATE CartProduct SET numberOfProducts=:number WHERE id = :id")
    suspend fun updateCartProduct(number: Int, id: Int)

    @Transaction
    @Query("Delete From CartProduct Where id=:id")
    suspend fun deleteCartProductById(id: Int)
}