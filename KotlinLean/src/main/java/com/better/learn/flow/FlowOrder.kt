package com.better.learn.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    /*
    类似sequence
    1. 是对集合中的每个元素进行一整套变换。
    2. 直到有结果操作请求时，才进行转换
    这个flow，带有协程的sequence
     */
    runBlocking {
        val flow = (1..5).asFlow()
            .filter {
                System.out.println("filter $it")
                it > 2
            }
            .map {
                System.out.println("map $it")
                "$it mapped"
            }

        System.out.println("___start to List")
        val result = flow.toList()
        System.out.println("___iterate result list")
        result.forEach {
            System.out.println("result $it")
        }
    }
}
