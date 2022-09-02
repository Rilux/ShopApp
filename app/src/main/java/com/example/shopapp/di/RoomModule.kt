package com.example.shopapp.di

import android.content.Context
import androidx.room.Room
import com.example.shopapp.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabaseInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "ShopDb"
        ).build()

    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase) = db.productsDao()

    @Provides
    @Singleton
    fun provideCategoryWithProductsDao(db: AppDatabase) = db.categoryWithProductsDao()

    @Provides
    @Singleton
    fun provideCartProductDao(db: AppDatabase) = db.cartProductDao()

    @Provides
    @Singleton
    fun provideUserDao(db: AppDatabase) = db.userDao()

}