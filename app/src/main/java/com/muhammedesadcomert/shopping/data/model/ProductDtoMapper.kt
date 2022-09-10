package com.muhammedesadcomert.shopping.data.model

import com.muhammedesadcomert.shopping.domain.model.Product
import com.muhammedesadcomert.shopping.domain.util.DomainMapper
import javax.inject.Inject

class ProductDtoMapper @Inject constructor() : DomainMapper<ProductData, Product> {
    override fun mapToDomainModel(model: ProductData): Product =
        Product(
            title = model.title,
            image = model.featuredImage!!.t,
            price = model.price,
            campaignPrice = model.campaignPrice
        )

    fun toDomainList(initial: List<ProductData>): List<Product> =
        initial.map(this::mapToDomainModel)
}