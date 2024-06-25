package com.better.learn.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 等待两个任务完成
 */
fun main() = runBlocking {
    runBlocking {
      val job1 =   launch {
            delay(2000L)
            println("Hello！")
        }
       val job2 = launch {
            delay(1000L)
            println("World")
        }
        job1.join()
        job2.join()
        println("done")
    }
    println("-.-")

    launch {
        val job1 =   launch {
            delay(2000L)
            println("Hello！")
        }
        val job2 = launch {
            delay(1000L)
            println("World")
        }
        job1.join()
        job2.join()
        println("done")
    }.join()
    println("-.-")

    launch {
        launch {
            delay(2000)
            println("Hello")
        }.join()
        delay(1000L)
        println("World")
        println("done")
    }.join()
    println("-.-")
}