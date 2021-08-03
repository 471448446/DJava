package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val noBuffer = measureTimeMillis {
            // 发送100、接受300、处理一个数字耗时400，一共三个数字所有最后耗时大概耗时 400*3 = 1200
            simpleDelay().collect {
                // 假设接受端处理数据耗时300 毫秒
                delay(300)
                println("collected $it")
            }
        }
        println("no Buffer $noBuffer")
        val useBuffer = measureTimeMillis {
            // 发送100、接受300、处理一个数字耗时400，
            // 但是使用了buffer() 操作符，并发的运行发送端来发送数据，而不是默认的顺序执行。
            // 发送端只耗时100毫秒，接收端，处理三个数字，耗时900毫秒，总计耗时1秒左右
            simpleDelay()
                .buffer()
                .collect {
                    // 假设接受端处理数据耗时300 毫秒
                    delay(300)
                    println("collected $it")
                }
        }
        println("no Buffer $useBuffer")
    }
}

/**
 * 下面模拟的执行耗时任务
 */
fun simpleDelay(): Flow<Int> = flow {
    (1..3).forEach {
        // 假设每次发送数据耗时100毫秒
        delay(100)
        emit(it)
    }
}