package com.tenutz.draghandlebs

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

fun BottomSheetDialogFragment.makeDraggableByHandle(dragHandle: View, scrollVerticalRatio: Float = 0.45f, animatorDuration: Long = 300L, interpolatorFactor: Float = 2f) {

    val rootView = this@makeDraggableByHandle.requireView()
    val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)!!
    val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

    bottomSheetBehavior.isDraggable = false

    dragHandle.setOnTouchListener(object : View.OnTouchListener {

        private var lastTouchY = 0f

        @SuppressLint("ClickableViewAccessibility")
        override fun onTouch(v: View, event: MotionEvent): Boolean = when (event.action) {

            MotionEvent.ACTION_DOWN -> {
                updateTouchPosition(event)
                true
            }

            MotionEvent.ACTION_MOVE -> {
                drag(event)
                updateTouchPosition(event)
                true
            }

            MotionEvent.ACTION_UP -> {
                if (isOutOfBoundary()) {
                    toStateExpanded()
                } else {
                    toStateHidden()
                }
                true
            }

            else -> false
        }

        private fun updateTouchPosition(event: MotionEvent) {
            lastTouchY = event.rawY
        }

        private fun drag(event: MotionEvent) {
            val deltaY = event.rawY - lastTouchY

            val maxY = rootView.height.toFloat() + bottomSheet.top.toFloat()
            val minY = bottomSheet.top.toFloat()

            if (bottomSheet.y + deltaY in minY..maxY) {
                bottomSheet.y += deltaY
            }
        }

        private fun isOutOfBoundary() = bottomSheet.y < rootView.height.toFloat() * (1 - scrollVerticalRatio) + bottomSheet.top

        private fun toStateHidden() {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }

        private fun toStateExpanded() {
            ObjectAnimator.ofFloat(bottomSheet, "translationY", 0f).apply {
                interpolator = DecelerateInterpolator(interpolatorFactor)
                duration = animatorDuration
                start()
            }
        }
    })

}


