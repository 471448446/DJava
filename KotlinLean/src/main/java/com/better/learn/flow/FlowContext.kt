package com.better.learn.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Exception

fun context(): Flow<Int> = flow {
    for (i in (1..3)) {
        System.out.println("${Thread.currentThread().name} emit next $i")
        emit(i)
        delay(100)
    }
}

fun contextError() = flow {
    withContext(Dispatchers.Default) {
        for (i in (1..3)) {
            System.out.println("${Thread.currentThread().name} emit next $i")
            emit(i)
            delay(100)
        }
    }
}

fun main() {
    runBlocking {
        /*
        Flow的创建和请求调用必须再同一个Context
        既：request 的context和flow内部的context必须是一样的
         */
        context().toList()
        /*
        因为不是一个context，所以报错了java.lang.IllegalStateException: Flow invariant is violated:
         */
        try {
            contextError().toList()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        /*
        使用flowOn 函数来达到上面修改Context
         */
        contextError()
            .flowOn(Dispatchers.Default)
            .toList()
    }
}