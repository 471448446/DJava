package com.better.learn.flow2

import kotlinx.coroutines.runBlocking

/**
 * 末端操作符
 */
fun main() {
    runBlocking {
        // 求1到3 的平方和
        val sum = (1..3).map { it * it }
            .reduce { acc, i -> acc + i }
        println(sum)
    }
}