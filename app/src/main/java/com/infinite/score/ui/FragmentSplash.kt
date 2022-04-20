package com.infinite.score.ui

import com.example.baselibrary.base.BaseFragment
import com.infinite.score.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*

class FragmentSplash : BaseFragment(R.layout.fragment_splash) {


    companion object {

        @JvmStatic
        fun newInstance() = FragmentSplash()

    }

    override suspend fun initData() {

    }

    override suspend fun initView() {
        navigate(R.id.action_splashFragment_to_fragmentMain)

/*        Timer().schedule(object : TimerTask() {
            override fun run() {
                navigate(R.id.action_splashFragment_to_fragmentMain)
            }
        },3000)*/
    }

}