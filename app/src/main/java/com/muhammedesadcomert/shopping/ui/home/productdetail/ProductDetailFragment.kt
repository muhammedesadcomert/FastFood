package com.muhammedesadcomert.shopping.ui.home.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupDetails()
    }

//    private fun setupDetails() {
//        viewModel.getSingleProductDetail(requireArguments().get("productId") as String)
//        viewModel.productDetail.observe(viewLifecycleOwner) { product ->
//            with(binding) {
//                textViewProductTitle.text = product.title
//                textViewProductPrice.text =
//                    (product.price.toString()).plus(getString(R.string.price_postfix))
//
//                if (product.campaignPrice != null && product.campaignPrice != product.price) {
//                    textViewProductPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
//                    textViewProductPrice.setTextColor(Color.GRAY)
//                    textViewProductPrice.textSize = 16f
//                    textViewProductCampaignPrice.text =
//                        (product.campaignPrice.toString()).plus(getString(R.string.price_postfix))
//                    textViewProductCampaignPrice.visibility = View.VISIBLE
//                }
//
//                if (product.stock == 0) {
//                    imageViewSoldOut.visibility = View.VISIBLE
//                }
//
//                textViewProductDescription.text =
//                    Html.fromHtml(product.description, Html.FROM_HTML_MODE_LEGACY)
//                Glide.with(requireContext()).load(product.featuredImage!!.n)
//                    .placeholder(R.drawable.blank_screen)
//                    .into(imageViewProductImage)
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
