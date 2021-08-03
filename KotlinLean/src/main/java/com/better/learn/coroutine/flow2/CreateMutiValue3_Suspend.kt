package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * 返回时，有耗时任务
 */
fun main() = runBlocking {
    simpleUseSuspendList().forEach {
        System.out.println(it)
    }
}

suspend fun simpleUseSuspendList(): List<Int> {
    delay(1000)
    return listOf(1, 2, 3)
}