package com.better.learn.flow2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

/**
 *  不阻塞当前协程
 */
fun main() {
    runBlocking {
        (1..3).asFlow()
            .onEach { v -> println("Event: $v") }
            .launchIn(this)
        println("no block")
    }
}