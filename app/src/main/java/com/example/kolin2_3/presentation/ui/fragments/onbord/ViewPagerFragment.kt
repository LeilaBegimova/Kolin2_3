package com.example.kolin2_3.presentation.ui.fragments.onbord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kolin2_3.databinding.FragmentOnBordPagingFirstBinding
import com.example.kolin2_3.presentation.ui.adapter.OnBoardAdapter

class ViewPagerFragment : Fragment() {
    private lateinit var biding: FragmentOnBordPagingFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        biding = FragmentOnBordPagingFirstBinding.inflate(layoutInflater)
        return biding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() = with(biding) {
        val onBoardAdapter = OnBoardAdapter(this@ViewPagerFragment)
        onBordViewPajer.adapter = onBoardAdapter
        dotsIndicator.attachTo(onBordViewPajer)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}