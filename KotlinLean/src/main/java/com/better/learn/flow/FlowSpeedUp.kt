package com.better.learn.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun flowData() = flow {
    for (i in (1..3)) {
        delay(100)
        emit(i)
    }
}

/**
 * how to speed up processing
 * 生成过程：flow{} 的构造处
 * 消耗过程：最终怎么处理这个flow，比如 collect ,collect 就是一般的forEach
 * flow的生成和消耗可能是两个个耗时的过程，怎样来加速。
 * 结论：如果要处理每个元素的话只有buffer了，如果可以丢掉一些元素不处理，那么conflate和collectLatest都行
 */
fun main(args: Array<String>) {
    runBlocking {
        //=========================buffer
        /*
        flow 任务 耗时300 ms，collect任务耗时900ms
         */
        var time = measureTimeMillis {
            flowData().collect { value ->
                delay(300)
                System.out.println("collected value $value,done")
            }
        }
        System.out.println("way normal consume time = $time")
        /*
        flow 的任务被一起执行，结果任务还是挨个执行，让flow任务迸发执行concurrently
        ==> emit concurrently collect sequentially
         */
        time = measureTimeMillis {
            flowData()
                .buffer()
                .collect { value ->
                    delay(300)
                    System.out.println("collected buffered value $value,done")
                }
        }
        System.out.println("way buffer consume time = $time")
        //=========================conflate
        /*
         conflate 字面意思是合并。这里其实就是不一一执行每个flow 元素。而是执行最小的一个，那么有一些元素就会被丢失。
         相当于有新元素来的时候，如果还在处理，那么这个元素可能就不会在处理了。
         通过丢弃一些中间元素来达到加速目的
         ==>Conflation is one way to speed up processing when both the emitter and collector are slow. It does it by dropping emitted values.
         */
        time = measureTimeMillis {
            flowData()
                .conflate() // conflate emissions, don't process each one
                .collect { value ->
                    delay(300)
                    System.out.println("collected conflated value $value,done")
                }
        }
        System.out.println("way conflate consume time = $time")

        //=========================xxxLatest
        /*
         这类方式就更直接了，每次处理flow元素的时候，取消上次的收集并且重新启动
         ==》 The other way is to cancel a slow collector and restart it every time a new value is emitted
         */
        time = measureTimeMillis {
            flowData().collectLatest { value ->
                System.out.println("try collected latest value $value")
                delay(300)
                System.out.println("collected latest value $value,done")
            }
        }
        System.out.println("way collectLatest consume time = $time")

    }
}