package com.better.learn.flow2

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * 限长操作符
 */
fun main() {
    runBlocking {
        val flow: Flow<Int> = flow {
            try {
                emit(1)
                emit(2)
                // 由于只take 2个，所有后面的代码不会执行
                println("this will not execite")
                emit(3)
            } catch (e: Exception) {
                println(e.message)
            } finally {
                println("done with emit")
            }
        }

        flow
            .take(2)
            .collect {
                println(it)
            }
    }
}