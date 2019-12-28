package com.better.learn.flow

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

/**
 * 怎么组合 flow数据
 */
fun main() {
    runBlocking {
        //=========================zip 将两个数组，按照对应的position组合成一个新的数组
        val flow1 = flowOf(1, 2, 3)
        val flow2 = flowOf("A", "B", "C")
        flow1.zip(flow2) { a, b -> "$a+$b" }
            .collect { value ->
                System.out.println("zip result = $value ")
            }
        //========================= combine ??

    }
}