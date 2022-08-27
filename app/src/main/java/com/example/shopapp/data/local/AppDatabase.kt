package com.example.shopapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductDao
}