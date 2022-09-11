package com.muhammedesadcomert.shopping.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muhammedesadcomert.shopping.common.util.extension.startShimmerLayout
import com.muhammedesadcomert.shopping.common.util.extension.stopShimmerLayout
import com.muhammedesadcomert.shopping.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shimmerLayoutProducts.startShimmerLayout()
        initCategoryAdapter()
        handleCategories()
        initProductAdapter()
        handleProducts()
    }

    private fun handleCategories() {
        viewModel.categoriesUiState.observe(viewLifecycleOwner) { categoriesUiState ->
            if (!categoriesUiState.errorMessage.isNullOrEmpty()) {
                Toast.makeText(context, categoriesUiState.errorMessage, Toast.LENGTH_LONG).show()
            } else {
                categoryAdapter.submitList(categoriesUiState.categories)
            }
        }
    }

    private fun initCategoryAdapter() {
        categoryAdapter = CategoryAdapter { category ->
            binding.textViewCategory.text = category.name
            productAdapter.submitList(arrayListOf())
            binding.shimmerLayoutProducts.startShimmerLayout()
            viewModel.getProducts(category.id!!)
        }

        binding.recyclerViewCategories.apply {
            adapter = categoryAdapter
            setHasFixedSize(true)
        }
    }

    private fun handleProducts() {
        viewModel.productsUiState.observe(viewLifecycleOwner) { productsUiState ->
            if (!productsUiState.errorMessage.isNullOrEmpty()) {
                Toast.makeText(context, productsUiState.errorMessage, Toast.LENGTH_LONG).show()
            } else {
                productAdapter.submitList(productsUiState.products)
            }
            binding.shimmerLayoutProducts.stopShimmerLayout()
        }
    }

    private fun initProductAdapter() {
        productAdapter = ProductAdapter { product ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToProductDetailFragment(product.id!!)
            )
        }

        binding.recyclerViewProducts.apply {
            adapter = productAdapter
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}