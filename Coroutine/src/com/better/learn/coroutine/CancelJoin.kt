package com.better.learn.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex

suspend fun main() {
    Mutex()
    val job = GlobalScope.launch {
        var nextPrintTime = System.currentTimeMillis()
        var i = 0
        while (i < 5) { // 一个执行计算的循环，只是为了占用 CPU
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300)
    System.out.println("cancel")
    job.cancelAndJoin()
    System.out.println("now quite")
}