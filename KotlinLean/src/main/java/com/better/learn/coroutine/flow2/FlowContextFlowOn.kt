package com.better.learn.coroutine.flow2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        simpleContext()
            .flowOn(Dispatchers.Default)
            .collect {
                logThread("Collected $it")
            }
    }
}