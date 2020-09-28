package com.better.learn.flow2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 在调用处的上下文中进行
 */
fun main() {
    runBlocking {
        simpleContext().collect { value -> logThread("Collected $value") }
        logThread("-----------")
        // 上下文不一样导致异常
        withContext(Dispatchers.Default) {
            simpleContext2().collect { value -> logThread("Collected $value") }
        }
        logThread("-----------")
        // 下面的两种方式都会报错
        simpleContext2().collect { value -> logThread("Collected $value") }
        logThread("-----------")
        withContext(Dispatchers.IO) {
            simpleContext2().collect { value -> logThread("Collected $value") }
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
