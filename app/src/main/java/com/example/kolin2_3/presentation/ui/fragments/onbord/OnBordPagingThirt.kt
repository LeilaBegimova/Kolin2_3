package com.example.kolin2_3.presentation.ui.fragments.onbord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kolin2_3.R
import com.example.kolin2_3.data.PreferenceHelper
import com.example.kolin2_3.databinding.FragmentOnBordPagingThirtBinding

class OnBordPagingThirt : Fragment() {
    private lateinit var biding: FragmentOnBordPagingThirtBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        biding = FragmentOnBordPagingThirtBinding.inflate(layoutInflater)
        return biding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        biding.tvStartWork.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
            val preferenceHelper = PreferenceHelper(requireContext())
            preferenceHelper.isShovOnBoard = true
        }
    }
}