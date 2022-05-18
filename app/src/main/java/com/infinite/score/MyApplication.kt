package com.infinite.score

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 *Nmae:VeStrong
 *Time：2022/5/10
 *Author:贾晨
 *function:类功能
 *
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}