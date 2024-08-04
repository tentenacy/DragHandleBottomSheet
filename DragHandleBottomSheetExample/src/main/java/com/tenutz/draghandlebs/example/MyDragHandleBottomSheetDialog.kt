package com.tenutz.draghandlebs.example

import android.os.Bundle
import android.view.View
import com.tenutz.draghandlebs.example.databinding.BsMyBinding
import com.tenutz.draghandlebs.makeDraggableByHandle


class MyDragHandleBottomSheetDialog(
    private val onClickListener: (Int, Any?) -> Unit = { _, _ -> },
) : BaseBottomSheetDialogFragment<BsMyBinding>(R.layout.bs_my) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeDraggableByHandle(binding.constraintDragHandleContainer)
    }
}