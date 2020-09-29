package com.better.learn.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val channel = Channel<Int>()
        launch {
            repeat(5) {
                channel.send(it * it)
                // 调用关闭后，无法在发送数据
                if (it>4){
                    channel.close()
                }
            }
        }
        // 这里我们使用 `for` 循环来打印所有被接收到的元素（直到通道被关闭）
        for (x in channel) {
            println("receive: $x")
        }
        println("Done!")
    }
}