package com.better.learn.coroutine.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Flows represent asynchronously received sequences of values,
 *  flow 可以看出是异步的接受序列的值，既然是异步的可能就会延时。
 *  并没有想到者章用在哪个地方
 */
fun main(args: Array<String>) {
    runBlocking {
        //===========map 转换
        (1..3).asFlow()
//            .map { num -> "$num" }
            .map { requestFlow(it) }
            .collect { s ->
                System.out.println("map result $s")
            }
        //===========   flatMapConcat vs flattenConcat
        /*
        They wait for the inner flow to complete before starting to collect the next one
        前面的map操作结果是 Flow<String>，这里将他打平合并 结果是String了。
        在打平合并的时候是一个执行完了在执行下一个
         */
        var startTime = System.currentTimeMillis() // remember the start time

        (1..3).asFlow()
            .onEach { delay(100) }
            .flatMapConcat { requestFlow(it) }
            .collect { s ->
                System.out.println("flatMapConcat result => $s, consume ${System.currentTimeMillis() - startTime}")
            }
        //===========flatMapMerge
        /*
         * 将所有数据源合并在一起
         */
        startTime = System.currentTimeMillis() // remember the start time
        (1..3).asFlow()
            .onEach { delay(100) }
            .flatMapMerge { requestFlow(it) }
            .collect { s ->
                System.out.println("flatMapMerge result => $s,consume ${System.currentTimeMillis() - startTime}")
            }
        //===========flatMapLatest
        /*
         * 跟collectLatest类似，会丢弃一些中间值
         */
        startTime = System.currentTimeMillis()
        (1..3).asFlow()
            .onEach { delay(100) }
            .flatMapLatest { requestFlow(it) }
            .collect { s ->
                System.out.println("flatMapLatest result => $s,consume ${System.currentTimeMillis() - startTime}")
            }
    }
}

fun requestFlow(num: Int) =
    flow {
        emit("try handle $num")
        delay(300)
        emit("success get $num")
    }