package com.better.learn.coroutine.flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    /*
    类似sequence
    1. 是对集合中的每个元素进行一整套变换。
    2. 直到有结果操作请求时，才进行转换
    这个flow，带有协程的sequence
    一般一个suspend 函数只返回一个被挂起的值，如何返回多个挂起的值就可以用flow，既返回多个异步值。这里定义成flow。
    flow 中文意思是水流的意思，那么可以加一些列的操作，比如只取几个，进行转换。
    https://github.com/Kotlin/kotlinx.coroutines/blob/master/docs/flow.md
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
