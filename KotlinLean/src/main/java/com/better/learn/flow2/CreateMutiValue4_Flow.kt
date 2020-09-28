package com.better.learn.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 名为 flow 的 Flow 类型构建器函数。
 * flow { ... } 构建块中的代码可以挂起。
 * 函数 simpleUseList 不再标有 suspend 修饰符。
 * 流使用 emit 函数 发射 值。
 * 流使用 collect 函数 收集 值。
 */
fun main() = runBlocking {
    launch {
        for (i in 1..6) {
            delay(500)
            System.out.println("i am live")
        }
    }
    simpleUseFlow().collect {
        System.out.println(it)
    }
}

fun simpleUseFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}