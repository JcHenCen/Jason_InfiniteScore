package com.infinite.score

import android.os.Bundle
import com.example.baselibrary.base.BaseActivity
import com.hi.dhl.binding.viewbind
import com.infinite.score.databinding.ActivityMainBinding

class MainActivity : BaseActivity(R.layout.activity_main) {


    private val binding by viewbind<ActivityMainBinding>()


    override suspend fun initData(savedInstanceState: Bundle?) {

    }

    override suspend fun initView() {

    }



}