package com.better.learn.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//https://stackoverflow.com/questions/52522282/using-kotlinx-coroutines-in-intellij-idea-project
fun main() {
    System.out.println("...")
    GlobalScope.launch {
        delay(1000)
        System.out.println("Hello")
    }
    // 等待 coroutines 执行
    Thread.sleep(2000)
}