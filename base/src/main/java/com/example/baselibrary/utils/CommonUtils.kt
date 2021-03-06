package com.example.baselibrary.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.media.ExifInterface
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.annotation.IdRes
import androidx.annotation.RestrictTo
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.DialogFragment
import com.example.xlulibrary.ToastBox

/**
 * 复制原图Exif信息到压缩后图片的Exif信息
 * @param sourcePath 原图路径
 * @param targetPath 目标图片路径
 */
private fun copyExif(sourcePath: String, targetPath: String) {
    try {
        val source = ExifInterface(sourcePath)
        val target = ExifInterface(targetPath)
        source.javaClass.declaredFields.forEach { member ->//获取ExifInterface类的属性并遍历
            member.isAccessible = true
            val tag = member.get(source)//获取原图EXIF实例种的成员变量
            if (member.name.startsWith("TAG_") && tag is String) {//判断变量是否以TAG开头，并且是String类型
                target.setAttribute(tag, source.getAttribute(tag))//设置压缩图的EXIF信息
                target.saveAttributes()//保存属性更改
            }
        }
    } catch (e: Exception) {
    }
}

fun Context.hasPermission(permission: String): Boolean {
    return ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}


/**
 * TODO 判断是否在主线程
 * @param methodName
 */
@SuppressLint("RestrictedApi")
fun assertMainThread(methodName: String ?= ""){
    check(ArchTaskExecutor.getInstance().isMainThread) {
        ("Cannot invoke $methodName on a background thread")
    }
}


/**
 * 复制剪切板
 */
fun copy(context: Context, msg: String) {
    val clip = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    clip.text = msg
    ToastBox.showToast("已复制")
}

/**
 * Utility to find root view for ViewBinding in Activity
 */
fun findRootView(activity: Activity): View {
    val contentView = activity.findViewById<ViewGroup>(android.R.id.content)
    checkNotNull(contentView) { "Activity has no content view" }
    return when (contentView.childCount) {
        1 -> contentView.getChildAt(0)
        0 -> error("Content view has no children. Provide root view explicitly")
        else -> error("More than one child view found in Activity content view")
    }
}

fun DialogFragment.getRootView(viewBindingRootId: Int): View {
    val dialog = checkNotNull(dialog) {
        "DialogFragment doesn't have dialog. Use viewBinding delegate after onCreateDialog"
    }
    val window = checkNotNull(dialog.window) { "Fragment's Dialog has no window" }
    return with(window.decorView) {
        if (viewBindingRootId != 0) requireViewByIdCompat(
            viewBindingRootId
        ) else this
    }
}

fun <V : View> View.requireViewByIdCompat(@IdRes id: Int): V {
    return ViewCompat.requireViewById(this, id)
}

fun <V : View> Activity.requireViewByIdCompat(@IdRes id: Int): V {
    return ActivityCompat.requireViewById(this, id)
}

