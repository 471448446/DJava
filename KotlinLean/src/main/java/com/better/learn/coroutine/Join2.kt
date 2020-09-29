package com.better.learn.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 并没有打印 Hello,World
fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        System.out.println("World")
    }
    System.out.println("Hello,")
}