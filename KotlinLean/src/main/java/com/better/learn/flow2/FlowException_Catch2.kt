package com.better.learn.flow2

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 * 和FlowException_Catch1.kt 中最对比，尽可能将下游的异常，放到上游
 */
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
            .onEach {
                check(it <= 1)
            }
            .catch { e ->
                println("catch() exception $e")
            }
            .collect {
                println("collect: $it")
            }

    }
}