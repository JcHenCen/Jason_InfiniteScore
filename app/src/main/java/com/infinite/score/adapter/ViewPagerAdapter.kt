package com.infinite.score.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *Nmae:VeStrong
 *Time：2022/4/25
 *Author:贾晨
 *function:viewpager适配器
 *
 */

class ViewPagerAdapter(var fragments: List<Fragment> , fm : FragmentManager?) : FragmentStatePagerAdapter(fm!!) {


    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

}