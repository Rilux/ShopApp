package com.example.shopapp.di

import com.example.shopapp.data.local.dao.CartProductDao
import com.example.shopapp.data.local.dao.CategoryWithProductsDao
import com.example.shopapp.data.local.dao.ProductDao
import com.example.shopapp.data.remote.ApiService
import com.example.shopapp.data.repositories.*
import com.example.shopapp.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainPageRepository(
        apiService: ApiService,
        productDao: ProductDao,
        categoryWithProductsDao: CategoryWithProductsDao
    ): MainPageRepository = MainPageRepositoryImpl(apiService, productDao, categoryWithProductsDao)

    @Provides
    @Singleton
    fun provideCatalogueCategoriesListRepository(
        categoryWithProductsDao: CategoryWithProductsDao
    ): CatalogueCategoriesListRepository = CatalogueCategoriesListRepositoryImpl(categoryWithProductsDao)

    @Provides
    @Singleton
    fun provideProductsListByCategoryRepository(
        categoryWithProductsDao: CategoryWithProductsDao
    ): ProductsListByCategoryRepository = ProductsListByCategoryRepositoryImpl(categoryWithProductsDao)

    @Provides
    @Singleton
    fun provideProductDetailedRepository(
        cartProductDao: CartProductDao
    ): ProductDetailedRepository = ProductDetailedRepositoryImpl(cartProductDao)

    @Provides
    @Singleton
    fun provideCartRepository(
        productDao: ProductDao
    ): CartRepository = CartRepositoryImpl(productDao)
}