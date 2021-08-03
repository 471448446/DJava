package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        (1..3)
            .asFlow()
            .transform {
                // 模拟耗时操作
                delay(1000)
                // 可以发射多次，目前没想到有什么用
                emit("this is $it request")
                emit("this is $it request again")
            }
            .collect {
                println(it)
            }
    }
}