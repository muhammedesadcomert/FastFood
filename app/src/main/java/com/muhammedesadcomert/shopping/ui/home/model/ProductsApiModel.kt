package com.muhammedesadcomert.shopping.ui.home.model

import com.google.gson.annotations.SerializedName

data class ProductsApiModel(
    @SerializedName("success")
    val success: Boolean? = null,
    @SerializedName("data")
    val products: List<Product> = arrayListOf(),
    @SerializedName("meta")
    val meta: Meta? = null,
)

data class Product(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("appId")
    val appId: String? = null,
    @SerializedName("category")
    val productCategory: ProductCategory? = null,
    @SerializedName("categoryId")
    val categoryId: String? = null,
    @SerializedName("brand")
    val brand: Brand? = null,
    @SerializedName("brandId")
    val brandId: String? = null,
    @SerializedName("isUnLimitedStock")
    val isUnLimitedStock: Boolean? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("featuredImage")
    val featuredImage: FeaturedImage? = null,
    @SerializedName("images")
    val images: List<Images> = arrayListOf(),
    @SerializedName("videos")
    val videos: List<String> = arrayListOf(),
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("stock")
    val stock: Int? = null,
    @SerializedName("stockCode")
    val stockCode: String? = null,
    @SerializedName("price")
    val price: Double? = null,
    @SerializedName("currency")
    val currency: String? = null,
    @SerializedName("maxQuantityPerOrder")
    val maxQuantityPerOrder: Int? = null,
    @SerializedName("itemType")
    val itemType: String? = null,
    @SerializedName("campaignPrice")
    val campaignPrice: Double? = null,
    @SerializedName("shippingPrice")
    val shippingPrice: Int? = null,
    @SerializedName("orderIndex")
    val orderIndex: Int? = null,
    @SerializedName("isPublished")
    val isPublished: Boolean? = null,
    @SerializedName("isActive")
    val isActive: Boolean? = null,
    @SerializedName("publishmentDate")
    val publishmentDate: String? = null,
    @SerializedName("endDate")
    val endDate: String? = null,
    @SerializedName("createDate")
    val createDate: String? = null,
    @SerializedName("updateDate")
    val updateDate: String? = null,
    @SerializedName("useFixPrice")
    val useFixPrice: Boolean? = null,
    @SerializedName("variantData")
    val variantData: List<String> = arrayListOf(),
)

data class ProductCategory(
    @SerializedName("categoryId")
    val categoryId: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("icon")
    val icon: Icon? = null,
    @SerializedName("orderIndex")
    val orderIndex: Int? = null,
    @SerializedName("createDate")
    val createDate: String? = null,
    @SerializedName("updateDate")
    val updateDate: String? = null,
    @SerializedName("totalProducts")
    val totalProducts: Int? = null,
    @SerializedName("isActive")
    val isActive: Boolean? = null,
    @SerializedName("subCategories")
    val subCategories: List<String> = arrayListOf(),
)

data class Brand(
    @SerializedName("createDate")
    val createDate: String? = null,
    @SerializedName("icon")
    val icon: Icon? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("isActive")
    val isActive: Boolean? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("updateDate")
    val updateDate: String? = null,
)

data class FeaturedImage(
    @SerializedName("t")
    val t: String? = null,
    @SerializedName("n")
    val n: String? = null,
)

data class Images(
    @SerializedName("t")
    val t: String? = null,
    @SerializedName("n")
    val n: String? = null,
)

data class Icon(
    @SerializedName("t")
    val t: String? = null,
    @SerializedName("n")
    val n: String? = null,
)

data class Meta(
    @SerializedName("queryCount")
    val queryCount: Int? = null,
    @SerializedName("itemsCount")
    val itemsCount: Int? = null,
)