package com.better.learn.flow2

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        /*透明捕获*/
        // catch() 只处理上游的异常，后面的不能处理
        val flow = flow {
            for (i in 1..3) {
                println("Emitting $i")
                emit(i)
            }
        }
        flow
            .catch { e ->
                println("catch() exception $e")
            }
            .collect {
                check(it <= 1)
                println("collect: $it")
            }

    }
}