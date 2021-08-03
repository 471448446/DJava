package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // 多次collect
        launch {
            simpleUseFlow2()
                .filter { it % 2 == 0 }
                .collect {
                    System.out.println("%=0:$it")
                }
        }
        launch {
            delay(1000)
            simpleUseFlow2()
                .filter { it % 2 == 1 }
                .collect {
                    System.out.println("%=1:$it")
                }
        }
    }

}

fun simpleUseFlow2(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}