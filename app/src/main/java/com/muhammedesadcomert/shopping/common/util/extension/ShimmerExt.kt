package com.muhammedesadcomert.shopping.common.util.extension

import android.view.View
import com.facebook.shimmer.ShimmerFrameLayout

fun ShimmerFrameLayout.startShimmerLayout() {
    if (this.isShimmerVisible.not()) {
        this.showShimmer(true)
        this.visibility = View.VISIBLE
    }
}

fun ShimmerFrameLayout.stopShimmerLayout() {
    if (this.isShimmerVisible && this.isShimmerStarted) {
        this.hideShimmer()
        this.visibility = View.GONE
    }
}