package com.example.shopapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shopapp.data.local.entities.CartProduct

@Dao
interface CartProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: CartProduct)

    @Query("Select * From CartProduct")
    suspend fun getCartProducts(): List<CartProduct>

    @Query("Select * From CartProduct Where id = :id")
    suspend fun getCartProductById(id: Int): CartProduct

    @Query("SELECT EXISTS(SELECT * FROM CartProduct WHERE id = :id)")
    suspend fun isRowIsExist(id : Int) : Boolean

    @Query("UPDATE CartProduct SET numberOfProducts=:number WHERE id = :id")
    suspend fun updateCartProduct(number: Int, id: Int)
}