package com.better.learn.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
//延迟一段时间来等待另一个协程运行并不是一个好的选择。让我们显式（以非阻塞方式）等待所启动的后台 Job 执行结束
suspend fun main() {
    val job = GlobalScope.launch {
        delay(1000L)
        System.out.println("No Sleep")
    }
    job.join()
}