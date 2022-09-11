package com.muhammedesadcomert.shopping.di

import com.muhammedesadcomert.shopping.common.util.Constant.BASE_URL
import com.muhammedesadcomert.shopping.data.mapper.CategoryDtoMapper
import com.muhammedesadcomert.shopping.data.mapper.ProductDtoMapper
import com.muhammedesadcomert.shopping.data.mapper.ProductListDtoMapper
import com.muhammedesadcomert.shopping.data.remote.ApiService
import com.muhammedesadcomert.shopping.data.remote.AuthInterceptor
import com.muhammedesadcomert.shopping.data.repository.CategoryRepositoryImpl
import com.muhammedesadcomert.shopping.data.repository.ProductRepositoryImpl
import com.muhammedesadcomert.shopping.domain.repository.CategoryRepository
import com.muhammedesadcomert.shopping.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor) = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
            .setLevel(HttpLoggingInterceptor.Level.BODY)).build()

    @Provides
    @Singleton
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideAuthInterceptor() = AuthInterceptor()

    @Singleton
    @Provides
    fun provideProductRepository(
        apiService: ApiService,
        productListDtoMapper: ProductListDtoMapper,
        productDtoMapper: ProductDtoMapper,
    ): ProductRepository {
        return ProductRepositoryImpl(
            apiService = apiService,
            productListDtoMapper = productListDtoMapper,
            productDtoMapper = productDtoMapper
        )
    }

    @Singleton
    @Provides
    fun provideCategoryRepository(
        apiService: ApiService,
        categoryDtoMapper: CategoryDtoMapper,
    ): CategoryRepository {
        return CategoryRepositoryImpl(
            apiService = apiService,
            categoryDtoMapper = categoryDtoMapper
        )
    }
}