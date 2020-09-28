package com.better.learn.flow2

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Flow 是可以取消的，通过取消调用的 suspend 方法来来实现
 */
fun main() {
    runBlocking {
        // 如果超过2秒就取消发射
        val result = withTimeoutOrNull(2000) {
            simpleClod().collect {
                System.out.println(it)
            }
        }
        println(result)
        println("Done")
    }
}
