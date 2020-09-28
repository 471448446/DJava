package com.better.learn.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 * 注意，flatMapLatest 在一个新值到来时取消了块中的所有代码 (本示例中的 { requestFlow(it) }）。
 * 这在该特定示例中不会有什么区别，由于调用 requestFlow 自身的速度是很快的，不会发生挂起，
 * 所以不会被取消。然而，如果我们要在块中调用诸如 delay 之类的挂起函数，这将会被表现出来。
 */
fun main() {
    runBlocking {
        val startTime = System.currentTimeMillis() // 记录开始时间
        (1..3).asFlow().onEach { delay(100) } // 每 100 毫秒发射一个数字
            .flatMapLatest { requestFlow(it) }
            .collect { value ->
                // 收集并打印
                println("$value at ${System.currentTimeMillis() - startTime} ms from start")
            }
    }
}