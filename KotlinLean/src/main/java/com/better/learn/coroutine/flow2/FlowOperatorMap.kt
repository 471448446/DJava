package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        (1..3)
            .asFlow()
            .map {
                // 模拟耗时操作
                delay(1000)
                // 这就有点像，请求网络数据，将请求参数，转换为服务端结果
                "this is $it request"
            }.collect {
                println(it)
            }
    }
}