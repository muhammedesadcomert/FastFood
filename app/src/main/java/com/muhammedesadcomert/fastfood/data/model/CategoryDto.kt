package com.muhammedesadcomert.fastfood.data.model

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val categories: List<CategoryData> = arrayListOf()
)

data class CategoryData(
    @SerializedName("categoryId")
    val categoryId: String,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("icon")
    val icon: String? = null,
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
    val subCategories: ArrayList<String> = arrayListOf()
)
