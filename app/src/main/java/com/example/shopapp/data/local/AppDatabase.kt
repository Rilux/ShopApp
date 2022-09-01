package com.example.shopapp.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.shopapp.data.local.dao.CartProductDao
import com.example.shopapp.data.local.dao.CategoryWithProductsDao
import com.example.shopapp.data.local.dao.ProductDao
import com.example.shopapp.data.local.entities.CartProduct
import com.example.shopapp.data.local.entities.Category
import com.example.shopapp.data.local.entities.Product


@Database(
    entities = [Product::class, Category::class, CartProduct::class], version = 4,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2,
            spec = AppDatabase.MyAutoMigration::class
        ),
        AutoMigration(
            from = 2,
            to = 3,
            spec = AppDatabase.MyAutoMigration::class
        ),
        AutoMigration(
            from = 3,
            to = 4
        )
    ], exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductDao
    abstract fun categoryWithProductsDao(): CategoryWithProductsDao
    abstract fun cartProductDao(): CartProductDao

    @RenameColumn(
        tableName = "Product",
        fromColumnName = "category",
        toColumnName = "categoryName"
    )
    class MyAutoMigration : AutoMigrationSpec
}
