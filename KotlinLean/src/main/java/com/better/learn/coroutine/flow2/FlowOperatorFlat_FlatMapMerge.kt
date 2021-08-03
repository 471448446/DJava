package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * 注意，flatMapMerge 会顺序调用代码块（本示例中的 { requestFlow(it) }），
 * 但是并发收集结果流，相当于执行顺序是首先执行 map { requestFlow(it) } 然后在其返回结果上调用 flattenMerge。
 */
fun main() {
    runBlocking {
        //并发执行，
        val startTime = System.currentTimeMillis() // 记录开始时间
        // 每 100 毫秒发射一个数字
        (1..3).asFlow().onEach { delay(100) }
            .flatMapMerge {
                requestFlow(it)
            }
            .collect {
                println("collect $it  ${System.currentTimeMillis() - startTime} ms from start")
            }
    }
}