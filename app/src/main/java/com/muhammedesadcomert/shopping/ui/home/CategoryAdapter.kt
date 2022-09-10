package com.muhammedesadcomert.shopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedesadcomert.shopping.databinding.CategoryItemBinding
import com.muhammedesadcomert.shopping.domain.model.Category
import com.muhammedesadcomert.shopping.ui.home.CategoryAdapter.CategoryViewHolder

class CategoryAdapter(private val onItemClicked: (Category) -> Unit) :
    ListAdapter<Category, CategoryViewHolder>(DIFF_CALLBACK) {

    inner class CategoryViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            with(binding) {
                categoryName.text = category.name
                Glide.with(itemView).load(category.icon!!).into(categoryIcon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = currentList[position]
        holder.bind(category)
        holder.itemView.setOnClickListener {
            onItemClicked(category)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem == newItem
            }
        }
    }
}
