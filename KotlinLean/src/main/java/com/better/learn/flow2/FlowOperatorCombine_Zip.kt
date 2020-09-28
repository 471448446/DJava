package com.better.learn.flow2

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // 数字 1..3
        val nums = (1..3).asFlow()
        // 字符串
        val strs = flowOf("one", "two", "three", "Four")
        //长度不一样时，会被丢弃
        nums.zip(strs) { a, b -> "$a -> $b" } // 组合单个字符串
            .collect { println(it) } // 收集并打印
    }
}