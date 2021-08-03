package com.better.learn.coroutine.flow2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * 演示流时冷的，
 * “冷的“一个发布-订阅中的逻辑，发布者发布信息，订阅器中回收到消息。
 * ”冷的“表示只有当有订阅的时候才会触发发布者工作。
 * “这是返回一个流的 simpleUseList 函数没有标记 suspend 修饰符的主要原因。 通过它自己，simpleUseList() 调用会尽快返回且不会进行任何等待。该流在每次收集的时候启动， 这就是为什么当我们再次调用 collect 时我们会看到“Flow started”。”
 * 这里提到，使用FLow的方式构建的集合，省略了suspend 方法，既： simpleClod() 方法，没有使用suspend 方法标记，使得，
 * 在调用方法的时候，就出发Flow开始工作。这里其实是因为，suspend方法背后的执行逻辑是，使用回调+调度器的方式
 * 工作，没有使用suspend标记，意味着，调用方法就开始执行，没有其他的而等待操作。
 */
fun main() = runBlocking {
    val simple = simpleClod()
    System.out.println("start collect")
    simple.collect {
        System.out.println(it)
    }
    System.out.println("start collect")
    simple.collect {
        System.out.println(it)
    }
    // 通过Flow 内部实现了一个顺序，从日志中发现是先执行完第一个，在执行第二个。
}

fun simpleClod(): Flow<Int> = flow {
    System.out.println("flow start")
    for (i in 1..3) {
        delay(1000)
        println("Emitting $i")
        emit(i)
    }
}