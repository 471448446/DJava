package com.better.learn.coroutine.flow2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // 监听上游游异常。没有异常就是null
        (1..3).asFlow()
            .onCompletion { e ->
                println("Done have exception? $e")
            }
            .collect {
                println("collect: $it")
            }
        println("——————")
        // 监听下游异常
        // kotlinx-coroutines-core:1.3.2 发现并没打印异常,既，下游发生异常时，并没有检查到
        (1..3).asFlow()
            .onCompletion { e ->
                println("Done have exception? $e")
            }
            .collect {
                check(it <= 1) { "Collected $it failed" }
                println("collect: $it")
            }
    }
}