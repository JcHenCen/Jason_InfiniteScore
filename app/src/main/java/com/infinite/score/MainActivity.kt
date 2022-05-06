package com.infinite.score

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.viewpager.widget.ViewPager
import com.example.baselibrary.base.BaseActivity
import com.google.android.material.tabs.TabLayout
import com.hi.dhl.binding.viewbind
import com.infinite.score.adapter.ViewPagerAdapter
import com.infinite.score.databinding.ActivityMainBinding
import com.infinite.score.fragment.FindFragment
import com.infinite.score.fragment.PersonalFragment

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val binding by viewbind<ActivityMainBinding>()


    override suspend fun initData(savedInstanceState: Bundle?) {

    }

    override suspend fun initView() {
        setFragment()
        setEvent()
    }


    fun setEvent() {

        binding.vpViewpager.setScanScroll(false)

        binding.rgGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.rb_find -> binding.vpViewpager.setCurrentItem(0)
                R.id.rb_personal -> binding.vpViewpager.setCurrentItem(1)
            }
        }

        //vp监听   用不到
//        binding.vpViewpager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                binding.rgGroup.check(binding.rgGroup.getChildAt(position).id)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//
//        })
    }

    fun setFragment() {
        var findFragment = FindFragment()
        var personalFragment = PersonalFragment()

        var listFragment = listOf(findFragment, personalFragment)


        binding.vpViewpager.adapter = ViewPagerAdapter(listFragment, supportFragmentManager)

    }


}