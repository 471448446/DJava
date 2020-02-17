package com.better.learn.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/**
 * 怎么处理flow带来的异常
 */
fun main(args: Array<String>) {
    runBlocking {
        try {
            (1..3).asFlow()
                .collect { s ->
                    // 如果等于2抛出一个异常
                    System.out.println("get $s")
                    check(s == 2)
                }
        } catch (e: Exception) {
            System.out.println("" + e)
        }

    }
}