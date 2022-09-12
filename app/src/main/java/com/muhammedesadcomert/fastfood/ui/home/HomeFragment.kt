package com.muhammedesadcomert.fastfood.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.muhammedesadcomert.fastfood.R
import com.muhammedesadcomert.fastfood.databinding.FragmentHomeBinding
import com.muhammedesadcomert.fastfood.util.Constant.CURRENT_CATEGORY
import com.muhammedesadcomert.fastfood.util.extension.startShimmerLayout
import com.muhammedesadcomert.fastfood.util.extension.stopShimmerLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenuProvider()
        initCategoryAdapter()
        handleCategories()
        initProductAdapter()
        handleProducts()
    }

    private fun initMenuProvider() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when (menuItem.itemId) {
                        R.id.sort -> {
                            SortDialogFragment().show(this@HomeFragment.childFragmentManager, null)
                        }
                    }
                    return true
                }
            },
            viewLifecycleOwner,
            Lifecycle.State.RESUMED
        )
    }

    private fun handleCategories() {
        viewModel.categoriesUiState.observe(viewLifecycleOwner) { categoriesUiState ->
            if (!categoriesUiState.errorMessage.isNullOrEmpty()) {
                Toast.makeText(context, categoriesUiState.errorMessage, Toast.LENGTH_LONG).show()
            } else if (categoriesUiState.categories.isNotEmpty()) {
                categoryAdapter.submitList(categoriesUiState.categories)
            }
        }
    }

    private fun initCategoryAdapter() {
        categoryAdapter = CategoryAdapter { category ->
            category.id?.let {
                CURRENT_CATEGORY = it
            }
            viewModel.getProducts()
        }

        binding.recyclerViewCategories.apply {
            adapter = categoryAdapter
            setHasFixedSize(true)
        }
    }

    private fun handleProducts() {
        viewModel.productsUiState.observe(viewLifecycleOwner) { productsUiState ->
            if (productsUiState.isLoading) {
                binding.shimmerLayoutProducts.startShimmerLayout()
            } else if ((productsUiState.errorMessage.isNullOrEmpty()).not()) {
                Toast.makeText(context, productsUiState.errorMessage, Toast.LENGTH_LONG).show()
                binding.shimmerLayoutProducts.stopShimmerLayout()
            } else if (productsUiState.products.isNotEmpty()) {
                productAdapter.differ.submitList(productsUiState.products)
                binding.shimmerLayoutProducts.stopShimmerLayout()
            }
        }
    }

    private fun initProductAdapter() {
        productAdapter = ProductAdapter { product ->
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(product.id!!)
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
