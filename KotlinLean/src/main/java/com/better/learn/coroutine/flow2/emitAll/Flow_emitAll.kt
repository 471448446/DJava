package com.better.learn.coroutine.flow2.emitAll

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        // 尝试理解DataStore中data所代表的flow是怎样发送的

        howEmitAll()
        stateFlow()
        simpleActor(this, coroutineContext)
    }
}

/**
 * SimpleActor 只是一个用来切换协程的，通过Channel完成协程间的通信。
 */
suspend fun simpleActor(scope: CoroutineScope, coroutineContext: CoroutineContext) {
    val simpleActor = SimpleActor<Int>(
        // 1. 加上当前的context只是为了方便等到所有数据执行完成，才结束程序
        CoroutineScope(Dispatchers.IO + SupervisorJob()),
        {
            println("simpleActor: onComplete() $it")
        },
        { i, throwable ->
            println("simpleActor: onUndeliveredElement() $i,$throwable")
        }
    ) {
        println("simpleActor: consume() ${Thread.currentThread().name} $it")
    }
    (0..2).forEach {
        println(" ${Thread.currentThread().name} offer $it")
        simpleActor.offer(it)
    }
    scope.launch(Dispatchers.IO) {
        (0..2).forEach {
            println(" ${Thread.currentThread().name} offer $it")
            simpleActor.offer(it)
        }
    }
    //2 或者等待一下
    delay(1000)
}

/**
 * 演示外界通过data来获取数据，但是获取的数据是一个耗时操作，所以将数据保存在另外一个流里面downstreamFlow
 * data是一个冷的流，而真实的数据downstreamFlow一个热的流StateFlow，每一次收集不会触发构建
 * StateFlow中只保存了一个值，每一次更新数据，都会替换前面的值，既里面保存的最新的值。
 */
private suspend fun CoroutineScope.stateFlow() {
    println("use StateFlow")
    val downstreamFlow = MutableStateFlow(0)
    println("${downstreamFlow.first()}")
    // stateFlow的collect()会suspend阻塞当前协程
//    downstreamFlow.collect {
//        println("stateflow:$it")
//    }
    val data = flow {
        println("data flow work")
        emitAll(downstreamFlow
            .dropWhile {
                println("dropWhile($it)")
                it < 1
            }
        )
    }
    launch {
        // 模拟耗时操作来读取数据
        delay(1000)
        (0..3).forEach {
            downstreamFlow.value = it
            delay(100)
        }
    }
    var mill = measureTimeMillis {
        // 这里取到的值是1，因为1刚好不满足dropWhile{it<1}的条件
        println("first collect:${data.first()}")
    }
    println("first collect $mill ms")
    // 后面在取值就很快了
    delay(2000)
    mill = measureTimeMillis {
        // 这里取到的值是3，过了两秒后，downstreamFlow里面已经变为3了。
        println("second collect:${data.first()}")
    }
    println("second collect $mill ms")
}

/**
 * emitAll，虽然接收的Flow，其实意思是将flow中的数据都收集一遍，然后一起发送。
 */
private suspend fun howEmitAll() {
    println("just collect")
    // 假设这就是历史数据
    val flow1 = (0..9).asFlow().onEach { delay(100) }
    // 对外暴露的data
    val flow2: Flow<Int> = flow {
        println("data work")
        emitAll(flow1.dropWhile {
            // 只接收最后几个值
            it < 8
        })
    }

    flow2.collect {
        println(it)
    }
    // 上一步等价于直接在flow1上操作数据
    flow1.dropWhile { it < 5 }.collect {
        println("___$it")
    }
    // 上一步只是逻辑上由flow2来发送数据

    //again
    // 每次手机，flow2 的流会再次构建
    flow2.collect {
        println(it)
    }
//    println("first:${flow2.first()}")
}