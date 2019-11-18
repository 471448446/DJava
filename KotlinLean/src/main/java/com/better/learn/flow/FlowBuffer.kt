package com.better.learn.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun buffer() = flow {
    for (i in (1..3)) {
        delay(100)
        emit(i)
    }
}

fun main() {
    runBlocking {
        /*
        flow 任务 耗时300 ms，collect任务耗时900ms
         */
        var time = measureTimeMillis {
            buffer().collect { value ->
                delay(300)
                System.out.println("collected value $value")
            }
        }
        System.out.println("way 1 consume time = $time")
        /*
        flow 的任务被一起执行，结果任务还是挨个执行，让flow任务迸发执行concurrently
        ==> emit concurrently collect sequentially
         */
        time = measureTimeMillis {
            buffer()
                .buffer()
                .collect { value ->
                    delay(300)
                    System.out.println("collected buffer value $value")
                }
        }
        System.out.println("way buffer consume time = $time")
    }
}