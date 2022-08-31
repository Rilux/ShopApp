package com.example.shopapp.di

import com.example.shopapp.BuildConfig
import com.example.shopapp.data.local.dao.ProductDao
import com.example.shopapp.data.remote.ApiService
import com.example.shopapp.data.repositories.MainPageRepositoryImpl
import com.example.shopapp.repository.MainPageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named("MainPageRepository")
    fun provideMainPageRepository(
        apiService: ApiService,
        productDao: ProductDao
    ): MainPageRepository = MainPageRepositoryImpl(apiService, productDao)

    @Provides
    @Singleton
    fun provideApiService(client: OkHttpClient): ApiService =
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build();

    @Provides
    @Singleton
    fun providesInterceptor(): Interceptor = HttpLoggingInterceptor()
        .setLevel(
            if
                    (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        )

}