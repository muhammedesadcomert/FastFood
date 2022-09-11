package com.muhammedesadcomert.fastfood.data.mapper

import com.muhammedesadcomert.fastfood.data.model.ProductData
import com.muhammedesadcomert.fastfood.domain.model.Product
import com.muhammedesadcomert.fastfood.domain.util.DomainMapper
import javax.inject.Inject

class ProductListDtoMapper @Inject constructor() : DomainMapper<ProductData, Product> {
    override fun mapToDomainModel(model: ProductData): Product =
        Product(
            id = model.id,
            title = model.title,
            image = model.featuredImage!!.t,
            price = model.price,
            campaignPrice = model.campaignPrice
        )

    fun toDomainList(initial: List<ProductData>): List<Product> =
        initial.map(this::mapToDomainModel)
}
