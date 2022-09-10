package com.muhammedesadcomert.shopping.common.util.extension

import android.graphics.Paint
import android.graphics.Typeface
import android.widget.TextView
import com.muhammedesadcomert.shopping.R

fun TextView.strikeThroughOnText() {
    this.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
    this.setTextColor(resources.getColor(R.color.gray, resources.newTheme()))
    this.textSize = 14f
    this.typeface = Typeface.DEFAULT
}