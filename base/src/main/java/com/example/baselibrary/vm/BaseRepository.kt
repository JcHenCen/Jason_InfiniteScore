package com.example.baselibrary.vm

import com.example.baselibrary.http.ApiResponse
import com.example.baselibrary.http.NetState
import kotlinx.coroutines.*
import java.lang.Exception

/**
 * @ClassName BaseRepository
 * @Description
 * @Author AlexLu_1406496344@qq.com
 * @Date 2021/5/12 10:03
 */
open class BaseRepository(private val coroutineScope: CoroutineScope) {


    /**
     * 异步请求
     */
    protected fun <T> launch(
        block: suspend () -> ApiResponse<T>,
        response: suspend (ApiResponse<T>) -> Unit,
        error: suspend () -> Unit = {  }
    ) = coroutineScope.launch(Dispatchers.IO){
        var result = ApiResponse<T>()
        try {
            result.netState = NetState.STATE_LOADING
            //开始请求数据
            val invoke = block.invoke()
            //将结果复制给baseResp
            result = invoke
            when(result.code){
                0,200 -> {
                    //请求成功，判断数据是否为空
                    if (result.data == null || result.data is List<*> && (result.data as List<*>).size == 0) {
                        //数据为空,结构变化时需要修改判空条件
                        result.netState = NetState.STATE_EMPTY
                    } else {
                        //请求成功并且数据为空的情况下，为STATE_SUCCESS
                        result.netState = NetState.STATE_SUCCESS
                    }
                }
                400,401 -> {
                    result.netState = NetState.STATE_FAILED
                }
            }
        }catch (e: Exception){
            result.netState = NetState.STATE_ERROR
            e.printStackTrace()
        }finally {
            when (result.netState){
                NetState.STATE_UNSTART,NetState.STATE_LOADING,NetState.STATE_EMPTY -> {

                }
                NetState.STATE_SUCCESS -> {
                    response(result)
                }
                NetState.STATE_FAILED,NetState.STATE_ERROR -> {
                    error()
                }
            }
        }
    }

    /**
     * 同步请求
     */
    protected fun <T> execute(
        block: suspend () -> ApiResponse<T>
    ) : ApiResponse<T> {
        var result = ApiResponse<T>()
        runBlocking{
            try {
                result.netState = NetState.STATE_LOADING
                //开始请求数据
                val invoke = block.invoke()
                //将结果复制给baseResp
                result = invoke
                when(result.code){
                    0,200 -> {
                        //请求成功，判断数据是否为空
                        if (result.data == null || result.data is List<*> && (result.data as List<*>).size == 0) {
                            //数据为空,结构变化时需要修改判空条件
                            result.netState = NetState.STATE_EMPTY
                        } else {
                            //请求成功并且数据为空的情况下，为STATE_SUCCESS
                            result.netState = NetState.STATE_SUCCESS
                        }
                    }
                    400,401 -> {
                        result.netState = NetState.STATE_FAILED
                    }
                }
            }catch (e:Exception){
                result.netState = NetState.STATE_ERROR
                e.printStackTrace()
            }
        }
        return result
    }


}