package com.muhammedesadcomert.fastfood.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedesadcomert.fastfood.R
import com.muhammedesadcomert.fastfood.databinding.ProductItemBinding
import com.muhammedesadcomert.fastfood.domain.model.Product
import com.muhammedesadcomert.fastfood.ui.home.ProductAdapter.ProductViewHolder
import com.muhammedesadcomert.fastfood.util.Constant.PRICE_SUFFIX
import com.muhammedesadcomert.fastfood.util.extension.strikeThroughOnText

class ProductAdapter(private val onItemClicked: (Product) -> Unit) :
    ListAdapter<Product, ProductViewHolder>(DIFF_CALLBACK) {

    inner class ProductViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            with(binding) {
                textViewProductTitle.text = product.title
                textViewProductPrice.text = product.price.toString().plus(PRICE_SUFFIX)
                if (product.campaignPrice != null && product.campaignPrice != product.price) {
                    textViewProductPrice.strikeThroughOnText()
                    textViewProductCampaignPrice.text =
                        product.campaignPrice.toString().plus(PRICE_SUFFIX)
                    textViewProductCampaignPrice.visibility = View.VISIBLE
                }
                Glide.with(itemView).load(product.image)
                    .placeholder(R.drawable.blank_detail_image)
                    .into(imageViewProductImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = currentList[position]
        holder.bind(product)
        holder.itemView.setOnClickListener {
            onItemClicked(product)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }
        }
    }
}
