package com.better.learn.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            // 第一、二次的收集器，都被取消了。所有只执行了3个发射端对的数据100毫秒和最后一次的收集器数据300毫秒
            simpleDelay().collectLatest {
                delay(300)
                println("collect $it")
            }
        }
        println("collectLatest $time")
    }
}