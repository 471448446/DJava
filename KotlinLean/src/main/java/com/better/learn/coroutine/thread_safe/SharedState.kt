package com.better.learn.coroutine.thread_safe

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
//https://www.kotlincn.net/docs/reference/coroutines/shared-mutable-state-and-concurrency.html
// Thread confinement 线程限制，协程中的解决并发问题的方式，将所有的操作限制到一个线程中，协程就没有并发问题了，协程只有这一个线程进行调度，虽然启动了多个协程，但是挨个调度的。
fun main() {
    runBlocking {
        var counter = 0
        withContext(Dispatchers.Default) {
            task {
                counter++
            }
        }
        println("counter:$counter")
    }
}

suspend fun task(action: () -> Unit) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        // 创建一个新的scope
        // 启动n个协程
        coroutineScope {
            repeat(n) {
                launch {
                    /*println("$it")*/
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}
