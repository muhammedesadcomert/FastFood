package com.muhammedesadcomert.shopping.ui.home.model

import com.google.gson.annotations.SerializedName

data class CategoryApiModel(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val categories: List<Category>,
)

data class Category(
    @SerializedName("categoryId")
    val categoryId: String,
    @SerializedName("createDate")
    val createDate: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("orderIndex")
    val orderIndex: Int,
    @SerializedName("subCategories")
    val subCategories: List<Any>,
    @SerializedName("totalProducts")
    val totalProducts: Int,
    @SerializedName("updateDate")
    val updateDate: String,
)