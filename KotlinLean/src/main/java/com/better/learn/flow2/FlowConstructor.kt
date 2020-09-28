package com.better.learn.flow2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

/**
 * 流构造器
 */
fun main() {
    runBlocking {
        flowOf(1, 2, 3).collect {
            println(it)
        }
        arrayOf(1, 2, 3).asFlow().collect {
            println(it)
        }
    }
}