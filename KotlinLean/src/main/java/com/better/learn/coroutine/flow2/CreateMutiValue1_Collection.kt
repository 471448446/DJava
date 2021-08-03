package com.better.learn.coroutine.flow2

/**
 * https://www.kotlincn.net/docs/reference/coroutines/flow.html
 */
fun main() {
    simpleUseList().forEach {
        System.out.println(it)
    }
}
fun simpleUseList(): List<Int> = listOf(1, 2, 3)
