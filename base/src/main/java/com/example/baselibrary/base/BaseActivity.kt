package com.example.baselibrary.base

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.drake.statusbar.darkMode
import com.drake.statusbar.statusBarColor
import com.example.baselibrary.lifecycle.ActivityStack
import com.example.baselibrary.utils.findRootView
import com.example.baselibrary.utils.other.Color
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

abstract class BaseActivity(@LayoutRes private val layout: Int? = null) : AppCompatActivity() {

    val TAG by lazy {
        this.javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout?.let {
            setContentView(it)
        }
        //设置状态栏黑色字体 背景透明
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


        initStatusBar()
        _initData(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        _initView()
    }

    //避免重复初始化
    private var isInitData = false
    private fun _initData(savedInstanceState: Bundle? = null) = lifecycleScope.launch {
        if (isInitData) return@launch else isInitData = true
        initData(savedInstanceState)
    }

    private var isInitView = false
    private fun _initView() = lifecycleScope.launch {
        if (isInitView) return@launch else isInitView = true
        initView()
    }

    abstract suspend fun initView()

    abstract suspend fun initData(savedInstanceState: Bundle? = null)

    /**
     * 更新状态栏，背景颜色和字体颜色
     */
    open fun initStatusBar() {
        val background = findRootView(this).background
        if (background is ColorDrawable) {
            val color = background.color
            val isWhite = Color.isWhiteColor(color)
            //requireActivity().immersive(color,darkMode = isWhite)
            this.statusBarColor(background.color)
            ActivityStack.currentActivity?.darkMode(isWhite)
        }
    }

    /**
     * 界面设置状态栏字体颜色
     */
    open fun changeStatusBarTextImgColor(isBlack: Boolean) {
        if (isBlack) {
            //设置状态栏黑色字体
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            //恢复状态栏白色字体
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
    }


    override fun onDestroy() {
        lifecycleScope.cancel()
        super.onDestroy()
    }

}