package com.better.learn.coroutine.flow2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 在调用处的上下文中进行
 * 流的收集总是在调用协程的上下文中发生。例如，如果有一个流 simple，然后以下代码在它的编写者指定的上下文中运行，而无论流 simple 的实现细节如何
 */
fun main() {
    runBlocking {
        // collect发生的上下文，就是流发送的上下文
        // 直接在Main中收集
        simpleContext().collect { value -> logThread("Collected $value") }
        logThread("-----------")
        // collect指定了在Dispatchers.Default中运行，simpleContext()也在Dispatchers.Default中运行
        withContext(Dispatchers.Default) {
            simpleContext().collect { value -> logThread("Collected $value") }
        }
    }
}

fun logThread(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun simpleContext(): Flow<Int> = flow {
    logThread("Started simpleUseList flow")
    for (i in 1..3) {
        emit(i)
    }
}

fun simpleContext2(): Flow<Int> = flow {
    withContext(Dispatchers.Default) {
        logThread("Started simpleUseList flow")
        for (i in 1..3) {
            emit(i)
        }
    }
}
