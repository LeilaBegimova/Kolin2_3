package com.example.kolin2_3.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kolin2_3.presentation.ui.fragments.onbord.OnBordPagingFirst
import com.example.kolin2_3.presentation.ui.fragments.onbord.OnBordPagingSecond
import com.example.kolin2_3.presentation.ui.fragments.onbord.OnBordPagingThirt

class OnBoardAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBordPagingFirst()
            1 -> OnBordPagingSecond()
            else -> OnBordPagingThirt()


        }
    }

}