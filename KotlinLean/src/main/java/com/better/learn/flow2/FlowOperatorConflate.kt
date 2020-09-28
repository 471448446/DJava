package com.better.learn.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // 由于发送端每一个需要耗时100，接收端处理数据耗时300。
        // 所有当第一个正在被处理时，第二个、第三个都完成了发送。conflate只取最新的，第二个就被忽略掉了。
        // 我们看到，虽然第一个数字仍在处理中，但第二个和第三个数字已经产生，因此第二个是 conflated ，只有最新的（第三个）被交付给收集器：
        simpleDelay()
            .conflate()
            .collect {
                delay(300)
                println("collected $it")
            }
    }
}