package com.tenutz.draghandlebs.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tenutz.draghandlebs.example.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private var _binding: FragmentMainBinding? = null
    val binding: FragmentMainBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnMainShowBs.setOnClickListener {
            MyBottomSheetDialog()
                .show(childFragmentManager, "MyBottomSheetDialog")
        }
        binding.btnMainShowDragHandleBs.setOnClickListener {
            MyDragHandleBottomSheetDialog()
                .show(childFragmentManager, "MyBottomSheetDialog")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}