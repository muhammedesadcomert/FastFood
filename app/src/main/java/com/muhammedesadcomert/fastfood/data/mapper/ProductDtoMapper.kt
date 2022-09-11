package com.muhammedesadcomert.fastfood.data.mapper

import com.muhammedesadcomert.fastfood.data.model.ProductData
import com.muhammedesadcomert.fastfood.domain.model.Product
import com.muhammedesadcomert.fastfood.domain.util.DomainMapper
import javax.inject.Inject

class ProductDtoMapper @Inject constructor() : DomainMapper<ProductData, Product> {
    override fun mapToDomainModel(model: ProductData): Product =
        Product(
            id = model.id,
            image = model.featuredImage!!.n,
            title = model.title,
            description = model.description,
            price = model.price,
            campaignPrice = model.campaignPrice,
            stock = model.stock
        )
}
