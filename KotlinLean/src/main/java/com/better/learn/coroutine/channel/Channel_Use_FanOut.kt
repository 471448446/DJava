package com.better.learn.coroutine.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

/**
 * 多个协程也许会接收相同的管道，在它们之间进行分布式工作。
 * 5个协程中，每一个并没有重复获取某一个值，通道中的值，只会被一个协程消耗
 */
fun main() {
    runBlocking {
        val producer = produceNumbers()
        repeat(5) { launchProcessor(it, producer) }
        delay(950)
        // 取消生产者通道，可以直接取消所有的通道接收者
        producer.cancel()
    }
}

fun CoroutineScope.produceNumbers() = produce {
    var x = 1 // start from 1
    // 假设一秒钟产生10个数字
    while (true) {
        send(x++)
        delay(100)
    }
}

/**
 * 它们只是打印它们的 id 和接收到的数字：
 */
fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel) {
        println("Processor #$id received $msg")
    }
}