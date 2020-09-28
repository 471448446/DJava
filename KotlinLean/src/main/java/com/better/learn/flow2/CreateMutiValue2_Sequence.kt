package com.better.learn.flow2


/**
 * 返回时，有耗时任务
 */
fun main() {
    simpleUseSequence().forEach {
        System.out.println(it)
    }
}

fun simpleUseSequence(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(1000)
        yield(i)
    }
}