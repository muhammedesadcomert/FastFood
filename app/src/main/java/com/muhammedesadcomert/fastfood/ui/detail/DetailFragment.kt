package com.muhammedesadcomert.fastfood.ui.detail

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.muhammedesadcomert.fastfood.R
import com.muhammedesadcomert.fastfood.databinding.FragmentDetailBinding
import com.muhammedesadcomert.fastfood.util.extension.startShimmerLayout
import com.muhammedesadcomert.fastfood.util.extension.stopShimmerLayout
import com.muhammedesadcomert.fastfood.util.extension.strikeThroughOnText
import com.muhammedesadcomert.fastfood.util.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewModel.getSingleProductDetail(requireArguments().get("productId") as String)
        viewModel.productUiState.observe(viewLifecycleOwner) { productUiState ->
            if (productUiState.isLoading) {
                binding.shimmerLayout.startShimmerLayout()
            } else if (!productUiState.errorMessage.isNullOrEmpty()) {
                Toast.makeText(context, productUiState.errorMessage, Toast.LENGTH_LONG).show()
            } else if (productUiState.product != null) {
                with(binding) {
                    val product = productUiState.product
                    textViewProductTitle.text = product.title
                    textViewProductPrice.text =
                        product.price.toString().plus(getString(R.string.price_suffix))

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
                        .placeholder(R.drawable.blank_detail_image)
                        .into(imageViewProductImage)

                    binding.shimmerLayout.stopShimmerLayout()
                    if (binding.shimmerLayout.visibility == View.GONE) {
                        binding.detailLayout.visible()
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
