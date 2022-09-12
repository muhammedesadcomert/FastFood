package com.muhammedesadcomert.fastfood.ui.home

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.muhammedesadcomert.fastfood.R
import com.muhammedesadcomert.fastfood.util.Constant.CURRENT_SORTING_TYPE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SortDialogFragment : DialogFragment() {

    private val viewModel: HomeViewModel by viewModels(ownerProducer = { requireParentFragment() })

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val sortingTypes = resources.getStringArray(R.array.sorting_types)
            val checkedItem = when (CURRENT_SORTING_TYPE) {
                sortingTypes[0] -> 0
                sortingTypes[1] -> 1
                sortingTypes[2] -> 2
                else -> 0
            }
            var selectedItem = checkedItem
            val builder = AlertDialog.Builder(it)
            builder.setTitle(getString(R.string.sort_dialog_title))
                .setSingleChoiceItems(
                    R.array.sorting_types,
                    checkedItem
                ) { _, which -> selectedItem = which }
                .setPositiveButton(R.string.ok) { _, _ ->
                    if (sortingTypes[selectedItem] != CURRENT_SORTING_TYPE) {
                        CURRENT_SORTING_TYPE = sortingTypes[selectedItem]
                        viewModel.getProducts(sortingType = sortingTypes[selectedItem])
                    }
                }
                .setNegativeButton(R.string.cancel) { _, _ -> dismiss() }
            builder.create()
        } ?: throw IllegalStateException(getString(R.string.sort_dialog_exception_message))
    }
}
