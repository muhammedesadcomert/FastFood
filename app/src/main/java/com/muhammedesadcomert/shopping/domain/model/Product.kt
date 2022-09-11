package com.muhammedesadcomert.shopping.domain.model

data class Product(
    val id: String? = null,
    val image: String? = null,
    val title: String? = null,
    val description: String? = null,
    val price: Double? = null,
    val campaignPrice: Double? = null,
    val stock: Int? = null
)
