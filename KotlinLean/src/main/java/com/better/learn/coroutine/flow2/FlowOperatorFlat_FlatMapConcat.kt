package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        //顺序连接流中的每一个值。每个数字对于一个requestFlow 中的流，一次执行
        val startTime = System.currentTimeMillis() // 记录开始时间
        // 每 100 毫秒发射一个数字
        (1..3).asFlow().onEach { delay(100) }
            .flatMapConcat {
                requestFlow(it)
            }
            .collect {
                println("collect $it  ${System.currentTimeMillis() - startTime} ms from start")
            }
    }
}

/**
 * 假设数字是参数，最后需要转换为结果，而结果也是流。
 * 先生成一段字符串，后面又生成一段字符串
 */
fun requestFlow(parameter: Int): Flow<String> = flow {
    emit("$parameter:first")
    delay(500)
    emit("$parameter:second")
}