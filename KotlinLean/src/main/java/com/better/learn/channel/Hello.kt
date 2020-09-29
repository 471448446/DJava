package com.better.learn.channel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 演示在两个协程间传递数据
 */
fun main() = runBlocking {
    val channel = Channel<Int>()
    launch(Dispatchers.Default) {
        (1..5).forEach {
            val i = it * it
            println("send: $i")
            channel.send(i)
        }
    }
    repeat(5) {
        val receive = channel.receive()
        println("receive: $receive")
    }
}