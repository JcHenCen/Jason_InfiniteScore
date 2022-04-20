package com.xlu.buildsrc

/**
 * @ClassName DependencyConfig
 * @Description
 * @Author AlexLu_1406496344@qq.com
 * @Date 2021/8/5 10:02
 */
object Dependency  {

    //是否允许module独立允许
    object RunAlone{
        const val base = false
    }

    object ProjectConfig {
        const val applicationId = "com.infinite.score"

        const val compileSdkVersion = 31
        const val buildToolsVersion = "30.0.2"
        const val minSdkVersion = 23
        const val targetSdkVersion = 31

        const val versionCode = 100
        const val versionName = "1.0.0"
    }

    object Version{

        // Android--------------------------------------------------------------
        const val Material = "1.4.0"
        const val AppCompat = "1.3.1"
        const val ConstraintLayout = "2.0.4"
        const val ActivityKtx = "1.1.0"
        const val FragmentKtx = "1.2.5"
        const val MultiDex = "2.0.1"
        const val legacySupport = "1.0.0"

        // Kotlin----------------------------------------------------------------
        const val Kotlin = "1.6.10"
        const val Coroutines = "1.5.0"
        const val CoreKtx = "1.6.0"
        
        // JetPack---------------------------------------------------------------
        const val Lifecycle = "2.5.0-alpha01"
        const val Navigation = "2.4.0"

        // GitHub----------------------------------------------------------------
        const val OkHttp = "4.9.0"                          // OkHttp
        const val OkHttpInterceptorLogging = "4.9.1"        // OkHttp 请求Log拦截器
        const val Retrofit = "2.9.0"                        // Retrofit
        const val RetrofitConverterGson = "2.9.0"           // Retrofit Gson 转换器
        const val Gson = "2.8.7"                            // Gson
        const val MMKV = "1.2.10"                            // 腾讯 MMKV 替代SP
        const val Permission = "0.12"                       // 权限申请
        const val LeakCanary = "2.7"                        // 检测内存泄漏

        const val Room = "2.3.0"                            //数据库
        const val Glide = "4.12.0"

    }

    object DependencyImp{

        //AndroidX
        const val AppCompat = "androidx.appcompat:appcompat:${Version.AppCompat}"
        const val Material = "com.google.android.material:material:${Version.Material}"
        const val AndroidXLegacy = "androidx.legacy:legacy-support-v4:${Version.legacySupport}"
        const val ActivityKtx = "androidx.activity:activity-ktx:${Version.ActivityKtx}"
        const val FragmentKtx = "androidx.fragment:fragment-ktx:${Version.FragmentKtx}"
        const val MultiDex = "androidx.multidex:multidex:${Version.MultiDex}"
        //Kotlin
        const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin}"
        const val CoreKtx = "androidx.core:core-ktx:${Version.CoreKtx}"
        const val CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
        const val CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"


        /*------------JetPack-----------------*/
        //navigation
        const val NavigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.Navigation}"
        const val NavigationUI = "androidx.navigation:navigation-ui-ktx:${Version.Navigation}"
        //lifecycle
        const val Lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle}"
        const val LifecycleService = "androidx.lifecycle:lifecycle-service:${Version.Lifecycle}"
        const val LifecycleCompilerAPT = "androidx.lifecycle:lifecycle-compiler:${Version.Lifecycle}"
        const val SaveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.Lifecycle}"
        const val Livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Lifecycle}"
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Lifecycle}"

        //recyclerView
        const val RecyclerView = "androidx.recyclerview:recyclerview:1.2.1"
        //viewPager
        const val Viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
        //ConstraintLayout
        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:${Version.ConstraintLayout}"
        const val StartUp = "androidx.startup:startup-runtime:1.1.0"


        /*------------工具-----------------*/
        // mmkv https://github.com/Tencent/MMKV
        const val MMKV = "com.tencent:mmkv-static:${Version.MMKV}"
        //room
        const val Room = "androidx.room:room-runtime:${Version.Room}"
        const val RoomAnnotationProcessor = "androidx.room:room-compiler:${Version.Room}"
        // Glide
        const val Glide = "com.github.bumptech.glide:glide:${Version.Glide}"
        const val GlideKapt = "com.github.bumptech.glide:compiler:${Version.Glide}"
        //glide图片变换库  https://github.com/wasabeef/glide-transformations
        const val GlideTran  = "jp.wasabeef:glide-transformations:4.3.0"
        //okhttp
        const val OkHttp = "com.squareup.okhttp3:okhttp:${Version.OkHttp}"
        const val OkHttpInterceptorLogging = "com.squareup.okhttp3:logging-interceptor:${Version.OkHttpInterceptorLogging}"
        //Retrofit
        const val Retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"
        const val RetrofitConverter = "com.squareup.retrofit2:converter-gson:${Version.RetrofitConverterGson}"
        const val Retrofitscalars = "com.squareup.retrofit2:converter-scalars:${Version.Retrofit}"
        const val Retrofitadapter = "com.squareup.retrofit2:adapter-rxjava3:${Version.Retrofit}"
        //gson
        const val Gson = "com.google.code.gson:gson:${Version.Gson}"
        const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.LeakCanary}"



        /*------------视图-----------------*/
        //阴影  https://github.com/lihangleo2/ShadowLayout
        const val ShadowLayout  = "com.github.lihangleo2:ShadowLayout:3.1.4"
        //动画库 https://lottiefiles.com/
        const val Lottie  = "com.airbnb.android:lottie:3.7.0"
        //toast工具  https://github.com/xluu233/ToastBox
        const val ToastBox = "com.github.xluu233:ToastBox:0.7.2"
        //https://liangjingkanji.github.io/StatusBar/
        const val StatusBar = "com.github.liangjingkanji:StatusBar:2.0.1"
        //https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/readme/0-BaseRecyclerViewAdapterHelper.md
        const val BRVA = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.7"

    }

}