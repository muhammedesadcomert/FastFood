package com.muhammedesadcomert.shopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedesadcomert.shopping.databinding.CategoryItemBinding
import com.muhammedesadcomert.shopping.ui.home.CategoryAdapter.CategoryViewHolder
import com.muhammedesadcomert.shopping.ui.home.model.Category

class CategoryAdapter(
    private val categories: List<Category>,
    private val onItemClicked: (Category) -> Unit,
) : RecyclerView.Adapter<CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            with(binding) {
                Glide.with(itemView).load(category.icon).into(categoryIcon)
                categoryName.text = category.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
        holder.itemView.setOnClickListener {
            onItemClicked(category)
        }
    }

    override fun getItemCount() = categories.size
}
