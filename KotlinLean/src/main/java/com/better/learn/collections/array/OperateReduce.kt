package com.better.learn.collections.array

import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val array = (1..10).toList()
        // 迭代元素，把上一次的值传递给下一个元素
        // fold有初始值,reduce没有
        val sum = array.reduce { acc, i ->
            acc + i
        }
        println(sum)
        val sum2 = array.fold(1) { acc, i ->
            acc + i
        }
        println(sum2)
    }
}