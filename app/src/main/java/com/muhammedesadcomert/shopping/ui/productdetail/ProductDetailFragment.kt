package com.muhammedesadcomert.shopping.ui.productdetail

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.muhammedesadcomert.shopping.R
import com.muhammedesadcomert.shopping.common.util.extension.strikeThroughOnText
import com.muhammedesadcomert.shopping.databinding.FragmentProductDetailBinding
import com.muhammedesadcomert.shopping.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)

        binding.shimmerLayout.apply {
            startShimmer()
            visibility = View.VISIBLE
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        binding.shimmerLayout.apply {
            stopShimmer()
            visibility = View.GONE
        }
    }

    private fun initView() {
        viewModel.getSingleProductDetail(requireArguments().get("productId") as String)
        viewModel.productUiState.observe(viewLifecycleOwner) { productUiState ->

//            changeProgressBarState(productUiState.isLoading)

            if (!productUiState.errorMessage.isNullOrEmpty()) {
                Toast.makeText(context, productUiState.errorMessage, Toast.LENGTH_LONG).show()
            } else {
                with(binding) {
                    productUiState.product?.let { product ->

                        textViewProductTitle.text = product.title
                        textViewProductPrice.text = product.price.toString()
                        (product.price.toString()).plus(getString(R.string.price_suffix))

                        if (product.campaignPrice != null && product.campaignPrice != product.price) {
                            textViewProductPrice.strikeThroughOnText()
                            textViewProductCampaignPrice.text =
                                (product.campaignPrice.toString()).plus(
                                    getString(R.string.price_suffix)
                                )
                            textViewProductCampaignPrice.visibility = View.VISIBLE
                        }

                        if (product.stock == 0) {
                            imageViewSoldOut.visibility = View.VISIBLE
                        }

                        textViewProductDescription.text =
                            Html.fromHtml(product.description, Html.FROM_HTML_MODE_LEGACY)

                        Glide.with(requireContext()).load(product.image)
                            .placeholder(R.drawable.blank_product_detail_image)
                            .into(imageViewProductImage)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
