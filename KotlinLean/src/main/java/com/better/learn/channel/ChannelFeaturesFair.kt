package com.better.learn.channel

import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class Ball(var hits: Int)

/**
 * 两个协程ping和pong，ping在前面所以先启动。
 * ping先启动，所以当通道里面有数据时，先获得元素。执行完成后调用通道在发送元素。
 * 虽然通过for循环，ping协程可以再次获得元素，但是由于通道时公平的，所以这一次，元素被传递给了pong协程。
 * pong协程使用完后，同理，传递给了ping协程。
 */
fun main() {
    runBlocking {
        val table = Channel<Ball>() // 一个共享的 table（桌子）
        launch { player("ping", table) }
        launch { player("pong", table) }
        table.send(Ball(0)) // 乒乓球
        delay(1000) // 延迟 1 秒钟
        coroutineContext.cancelChildren() // 游戏结束，取消它们
    }
}

suspend fun player(name: String, table: Channel<Ball>) {
    for (ball in table) { // 在循环中接收球
        ball.hits++
        println("$name $ball")
        delay(300) // 等待一段时间
        table.send(ball) // 将球发送回去
    }
}