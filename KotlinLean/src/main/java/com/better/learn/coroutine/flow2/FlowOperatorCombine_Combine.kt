package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * 当流表示一个变量或操作的最新值时（请参阅相关小节 conflation），可能需要执行计算，
 * 这依赖于相应流的最新值，并且每当上游流产生值的时候都需要重新计算
 */
fun main() {
    runBlocking {
        // 发射数字 1..3，间隔 300 毫秒
        val nums = (1..3).asFlow().onEach { delay(300) }
        // 每 400 毫秒发射一次字符串
        val strs = flowOf("one", "two", "three").onEach { delay(400) }
        /*========zip========*/
        println("zip")
        // 使用zip每一个会耗时400毫秒
        val startTime = System.currentTimeMillis() // 记录开始的时间
        nums.zip(strs) { a, b -> "$a -> $b" } // 使用“zip”组合单个字符串
            .collect { value ->
                // 收集并打印
                println("$value at ${System.currentTimeMillis() - startTime} ms from start")
            }
        /*========combine========*/
        println("combine")
        // 使用combine每当有值发生变化时，都会触发一次收集
        val startTime2 = System.currentTimeMillis() // 记录开始的时间
        nums.combine(strs) { a, b -> "$a -> $b" } // 使用“combine”组合单个字符串
            .collect { value ->
                // 收集并打印
                println("$value at ${System.currentTimeMillis() - startTime2} ms from start")
            }
    }
}