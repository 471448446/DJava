package com.better.learn.coroutine.flow2

import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import java.lang.Exception

fun main() {
    runBlocking {
        // flow{} 方式构建的，默认可以被取消
        try {
            simpleClod().collect {
                println("collect1：$it")
                if (it > 1) {
                    cancel()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        println("---------------------")
        // asFlow() 方式默认是莫法取消的，只有等到执行完成时，才检查到
        try {
            (1..3).asFlow().collect {
                println("collect2：$it")
                if (it > 1) {
                    cancel()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        println("---------------------")
        // asFlow() 使得它可以被取消
        try {
            (1..3).asFlow()
                // kotlinx-coroutines-core:1.3.2 不支持
//                .cancellable()
                .collect {
                    println("collect3：$it")
                    if (it > 1) {
                        cancel()
                    }
                }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}