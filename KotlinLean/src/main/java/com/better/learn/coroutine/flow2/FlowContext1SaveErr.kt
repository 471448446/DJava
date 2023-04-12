package com.better.learn.coroutine.flow2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * 在调用处的上下文中进行
 */
fun main() {
    runBlocking {
        // simpleContext2()的生成时在Dispatchers.Default中，collect时不一致会报错
        // flow{} 代码块中不能使用withContext来修改上下文，
        // 既:flow {...} 构建器中的代码必须遵循上下文保存属性，并且不允许从其他上下文中发射
        // 上下文不一样导致异常
        withContext(Dispatchers.Default) {
            simpleContext2().collect { value -> logThread("Collected $value") }
        }
        logThread("-----------")
        // 下面的两种方式都会报错
        simpleContext2().collect { value -> logThread("Collected $value") }
        logThread("-----------")
        withContext(Dispatchers.IO) {
            simpleContext2().collect { value -> logThread("Collected $value") }
        }
    }
}