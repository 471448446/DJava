package com.better.learn.coroutine.channel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // 从 1 开始生成整数
        val number = createNumber(1)
        // 整数求平方
        val numberSqrt = sqrtNumber(number)
        // 输出前五个
        repeat(5) {
            val i = numberSqrt.receive()
            println("receive: $i")
        }
        // 因为前面生成数字是 while(true) 所有取消所有协程
        coroutineContext.cancelChildren()
    }
}

/**
 * 我们开启了一个数字的无限序列。
 */
fun CoroutineScope.createNumber(start: Int) = produce {
    var x = start
    while (true) {
        println("$start:createNumber $x")
        send(x++)
    }
}

fun CoroutineScope.sqrtNumber(channel: ReceiveChannel<Int>): ReceiveChannel<Int> =
    produce {
        for (x in channel) send(x * x)
    }