package com.muhammedesadcomert.fastfood.util.extension

import com.facebook.shimmer.ShimmerFrameLayout

fun ShimmerFrameLayout.startShimmerLayout() {
    if (this.isShimmerVisible.not()) {
        this.showShimmer(true)
        this.visible()
    }
}

fun ShimmerFrameLayout.stopShimmerLayout() {
    if (this.isShimmerVisible && this.isShimmerStarted) {
        this.hideShimmer()
        this.gone()
    }
}
