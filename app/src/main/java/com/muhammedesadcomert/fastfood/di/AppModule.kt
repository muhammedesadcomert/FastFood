package com.muhammedesadcomert.fastfood.di

import com.muhammedesadcomert.fastfood.data.mapper.CategoryDtoMapper
import com.muhammedesadcomert.fastfood.data.mapper.ProductDtoMapper
import com.muhammedesadcomert.fastfood.data.mapper.ProductListDtoMapper
import com.muhammedesadcomert.fastfood.data.remote.AuthInterceptor
import com.muhammedesadcomert.fastfood.data.remote.ShopirollerApi
import com.muhammedesadcomert.fastfood.data.repository.CategoryRepositoryImpl
import com.muhammedesadcomert.fastfood.data.repository.ProductRepositoryImpl
import com.muhammedesadcomert.fastfood.domain.repository.CategoryRepository
import com.muhammedesadcomert.fastfood.domain.repository.ProductRepository
import com.muhammedesadcomert.fastfood.util.Constant.BASE_URL
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
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        ).build()

    @Provides
    @Singleton
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ShopirollerApi =
        retrofit.create(ShopirollerApi::class.java)

    @Provides
    fun provideAuthInterceptor() = AuthInterceptor()

    @Singleton
    @Provides
    fun provideProductRepository(
        shopirollerApi: ShopirollerApi,
        productListDtoMapper: ProductListDtoMapper,
        productDtoMapper: ProductDtoMapper,
    ): ProductRepository {
        return ProductRepositoryImpl(
            shopirollerApi = shopirollerApi,
            productListDtoMapper = productListDtoMapper,
            productDtoMapper = productDtoMapper
        )
    }

    @Singleton
    @Provides
    fun provideCategoryRepository(
        shopirollerApi: ShopirollerApi,
        categoryDtoMapper: CategoryDtoMapper,
    ): CategoryRepository {
        return CategoryRepositoryImpl(
            shopirollerApi = shopirollerApi,
            categoryDtoMapper = categoryDtoMapper
        )
    }
}
