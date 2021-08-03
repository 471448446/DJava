package com.better.learn.coroutine.flow2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/**
 * collect 是一个suspend 函数，其实只要collect执行完成，就算收集完成。
 * 但是可能又异常，所有需要在finally代码快中判断
 */
fun main() {
    runBlocking {
        try {
            (1..3).asFlow()
                .collect {
                    println("collect: $it")
                }
        } finally {
            println("Done")
        }
    }
}