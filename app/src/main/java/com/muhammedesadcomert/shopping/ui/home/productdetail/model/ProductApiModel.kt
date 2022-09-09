package com.muhammedesadcomert.shopping.ui.home.productdetail.model


import com.google.gson.annotations.SerializedName

data class ProductApiModel(
    @SerializedName("data")
    val product: Data?,
    @SerializedName("success")
    val success: Boolean?,
)

data class Data(
    @SerializedName("appId")
    val appId: String?,
    @SerializedName("campaignPrice")
    val campaignPrice: Double?,
    @SerializedName("category")
    val category: Category?,
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("createDate")
    val createDate: String?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("featuredImage")
    val featuredImage: FeaturedImage?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("images")
    val images: List<Image?> = arrayListOf(),
    @SerializedName("isActive")
    val isActive: Boolean?,
    @SerializedName("isPublished")
    val isPublished: Boolean?,
    @SerializedName("isUnLimitedStock")
    val isUnLimitedStock: Boolean?,
    @SerializedName("itemType")
    val itemType: String?,
    @SerializedName("maxQuantityPerOrder")
    val maxQuantityPerOrder: Int?,
    @SerializedName("orderIndex")
    val orderIndex: Int?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("publishmentDate")
    val publishmentDate: String?,
    @SerializedName("shippingPrice")
    val shippingPrice: Double?,
    @SerializedName("stock")
    val stock: Int?,
    @SerializedName("stockCode")
    val stockCode: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updateDate")
    val updateDate: String?,
    @SerializedName("useFixPrice")
    val useFixPrice: Boolean?,
    @SerializedName("variantData")
    val variantData: List<Any?> = arrayListOf(),
    @SerializedName("variants")
    val variants: List<Any?> = arrayListOf(),
    @SerializedName("variationGroups")
    val variationGroups: List<Any?> = arrayListOf(),
    @SerializedName("videos")
    val videos: List<Any?> = arrayListOf(),
)

data class FeaturedImage(
    @SerializedName("n")
    val n: String?,
    @SerializedName("t")
    val t: String?,
)

data class Image(
    @SerializedName("n")
    val n: String?,
    @SerializedName("t")
    val t: String?,
)

data class Category(
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("createDate")
    val createDate: String?,
    @SerializedName("icon")
    val icon: Icon?,
    @SerializedName("isActive")
    val isActive: Boolean?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("orderIndex")
    val orderIndex: Int?,
    @SerializedName("subCategories")
    val subCategories: List<Any?> = arrayListOf(),
    @SerializedName("totalProducts")
    val totalProducts: Int?,
    @SerializedName("updateDate")
    val updateDate: String?,
)

data class Icon(
    @SerializedName("n")
    val n: String?,
    @SerializedName("t")
    val t: String?,
)