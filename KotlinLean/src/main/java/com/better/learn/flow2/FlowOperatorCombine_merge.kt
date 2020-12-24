package com.better.learn.flow2

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * 将多个流合并在一起，流集合中的每一个发生变化，终端处都会收到对应的值。和combine不一样，它是将两个流中最新的值进行结合，结合后得出最终的值。
 * 下面的例子1演示了这种区别，flow1和flow2两个流，流中的数据都是一个数组。
 * 1. 使用merge的好处是最后在终端处都会收到两者的变化，既flow变化了，可以收到，flow2收到了还是可以收到
 * 2. 而使用combine缺可以将两个流中的值进行合并，这就大不一样了
 */
fun main() {
    runBlocking {
        //例1:
        val flow1 = flowOf(arrayOf(1, 2, 3))
//            .onEach {
//                delay(100)
//            }
        val flow2 = flowOf(arrayOf(7, 8, 9))
        merge(flow1, flow2).collect {
            println("merge:${it.joinToString(",")}")
        }
        flow1.combine(flow2) { f1, f2 ->
            f1 + f2
        }.collect {
            println("combine:${it.joinToString(",")}")
        }
        //例2:
        // 若其中一个是空的，可咋办
        // 结果是只有一flow的值，并不会阻塞，既不会没有结果
        val flow3 = flowOf(emptyArray<Int>())
        flow3.combine(flow1) { f1, f2 ->
            f1 + f2
        }.collect {
            println("combine_empty:${it.joinToString(",")}")
        }
    }
}